package example.rpc.server;

import example.rpc.common.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhout
 * @date 2020/9/10 16:35
 */
public class RPCServer {

  private final static Logger LOG = LoggerFactory.getLogger(RPCServer.class);

  private String ip;
  private int port;
  private int ioThreads;      // 用来处理网络流的读写线程
  private int workerThreads;  // 用于业务处理的计算线程
  private MessageHandlers handlers = new MessageHandlers();
  private MessageRegistry registry = new MessageRegistry();

  {
    handlers.defaultHandler(new DefaultHandler());
  }

  public RPCServer(String ip, int port, int ioThreads, int workerThreads) {
    this.ip = ip;
    this.port = port;
    this.ioThreads = ioThreads;
    this.workerThreads = workerThreads;
  }

  private ServerBootstrap bootstrap;
  private EventLoopGroup group;
  private MessageCollector collector;
  private Channel serverChannel;

  // 注册服务的快捷方式
  public RPCServer service(String type, Class<?> reqClass, IMessageHandler<?> handler) {
    registry.register(type, reqClass);
    handlers.register(type, handler);
    return this;
  }

  // 启动RPC服务
  public void start() {
    bootstrap = new ServerBootstrap();
    group = new NioEventLoopGroup(ioThreads);
    bootstrap.group(group);
    collector = new MessageCollector(handlers, registry, workerThreads);
    MessageEncoder encoder = new MessageEncoder();
    bootstrap
        .channel(NioServerSocketChannel.class)
        .childHandler(
            new ChannelInitializer<SocketChannel>() {
              @Override
              public void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipe = ch.pipeline();
                pipe.addLast(new ReadTimeoutHandler(60));// 如果客户端60秒没有任何请求，就关闭客户端链接
                pipe.addLast(new MessageDecoder());// 挂上解码器
                pipe.addLast(encoder);// 挂上编码器
                pipe.addLast(collector);// 将业务处理器放在最后
              }
            });
    bootstrap
        .option(ChannelOption.SO_BACKLOG, 100) // 客户端套件字接受队列大小
        .option(ChannelOption.SO_REUSEADDR, true) // reuse addr，避免端口冲突
        .option(ChannelOption.TCP_NODELAY, true) // 关闭小流合并，保证消息的及时性
        .childOption(ChannelOption.SO_KEEPALIVE, true); // 长时间没动静的链接自动关闭
    serverChannel = bootstrap.bind(this.ip, this.port).channel();
    LOG.warn("server started @ {}:{}\n", ip, port);
  }

  public void stop() {
    serverChannel.close();// 先关闭服务端套件字
    group.shutdownGracefully();// 再斩断消息来源，停止io线程池
    collector.closeGracefully();// 最后停止业务线程
  }
}
