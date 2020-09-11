package example.rpc.server;

import example.rpc.common.IMessageHandler;
import example.rpc.common.MessageHandlers;
import example.rpc.common.MessageInput;
import example.rpc.common.MessageRegistry;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhout
 * @date 2020/9/10 16:46
 */
public class MessageCollector extends ChannelInboundHandlerAdapter {

  private final static Logger LOG = LoggerFactory.getLogger(MessageCollector.class);

  private ThreadPoolExecutor executor;// 业务线程池
  private MessageHandlers handlers;
  private MessageRegistry registry;

  public MessageCollector(MessageHandlers handlers, MessageRegistry registry, int workerThreads) {
    // 业务队列最大1000，避免堆积
    // 如果子线程处理不过来，io线程也会加入处理业务逻辑(callerRunsPolicy)
    BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);
    // 给业务线程命名
    ThreadFactory factory =
        new ThreadFactory() {

          AtomicInteger seq = new AtomicInteger();

          @Override
          public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("rpc-" + seq.getAndIncrement());
            return t;
          }
        };
    // 闲置时间超过30秒的线程自动销毁
    this.executor =
        new ThreadPoolExecutor(
            1, workerThreads, 30, TimeUnit.SECONDS, queue, factory, new CallerRunsPolicy());
    this.handlers = handlers;
    this.registry = registry;
  }

  public void closeGracefully() {
    // 优雅一点关闭，先通知，再等待，最后强制关闭
    this.executor.shutdown();
    try {
      this.executor.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
    }
    this.executor.shutdownNow();
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    // 客户端来了一个新链接
    LOG.debug("connection comes");
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    // 客户端走了一个链接
    LOG.debug("connection leaves");
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    if (msg instanceof MessageInput) {
      // 用业务线程池处理消息
      this.executor.execute(
          () -> {
            this.handleMessage(ctx, (MessageInput) msg);
          });
    }
  }

  private void handleMessage(ChannelHandlerContext ctx, MessageInput input) {
    // 业务逻辑在这里
    Class<?> clazz = registry.get(input.getType());
    if (clazz == null) {
      // 没注册的消息用默认的处理器处理
      handlers.defaultHandler().handle(ctx, input.getRequestId(), input);
      return;
    }
    Object o = input.getPayload(clazz);
    // TODO 这里是的瑕疵，代码外观上比较难看，但是才艺不够，很无奈，待解决
    @SuppressWarnings("unchecked")
    IMessageHandler<Object> handler = (IMessageHandler<Object>) handlers.get(input.getType());
    if (handler != null) {
      handler.handle(ctx, input.getRequestId(), o);
    } else {
      // 用默认的处理器处理吧
      handlers.defaultHandler().handle(ctx, input.getRequestId(), input);
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    LOG.warn("connection error", cause);
    // 此处可能因为客户端机器突发重启
    // 也可能是客户端链接闲置时间超时，后面的ReadTimeoutHandler抛出来的异常
    // 也可能是消息协议错误，序列化异常
    // etc.
    // 不管它，链接统统关闭，反正客户端具备重连机制
    // System.out.println("connection error");
    // cause.printStackTrace();
    // ctx.close();
  }
}
