package example.rpc.client;

import example.rpc.common.MessageInput;
import example.rpc.common.MessageOutput;
import example.rpc.common.MessageRegistry;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import io.netty.channel.ChannelHandler.Sharable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * @author zhout
 * @date 2020/9/10 17:02
 */
@Sharable
public class MessageCollector extends ChannelInboundHandlerAdapter {

  private final static Logger LOG = LoggerFactory.getLogger(MessageCollector.class);

  private MessageRegistry registry;
  private RPCClient client;
  private ChannelHandlerContext context;
  private ConcurrentMap<String, RpcFuture<?>> pendingTasks = new ConcurrentHashMap<>();

  private Throwable ConnectionClosed = new Exception("rpc connection not active error");

  public MessageCollector(MessageRegistry registry, RPCClient client) {
    this.registry = registry;
    this.client = client;
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    this.context = ctx;
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    this.context = null;
    pendingTasks.forEach(
        (__, future) -> {
          future.fail(ConnectionClosed);
        });
    pendingTasks.clear();
    // 尝试重连
    ctx.channel()
        .eventLoop()
        .schedule(
            () -> {
              client.reconnect();
            },
            1,
            TimeUnit.SECONDS);
  }

  public <T> RpcFuture<T> send(MessageOutput output) {
    ChannelHandlerContext ctx = context;
    RpcFuture<T> future = new RpcFuture<T>();
    if (ctx != null) {
      ctx.channel()
          .eventLoop()
          .execute(
              () -> {
                pendingTasks.put(output.getRequestId(), future);
                ctx.writeAndFlush(output);
              });
    } else {
      future.fail(ConnectionClosed);
    }
    return future;
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    if (!(msg instanceof MessageInput)) {
      return;
    }
    MessageInput input = (MessageInput) msg;
    // 业务逻辑在这里
    Class<?> clazz = registry.get(input.getType());
    if (clazz == null) {
      LOG.error("unrecognized msg type {}", input.getType());
      return;
    }
    Object o = input.getPayload(clazz);
    @SuppressWarnings("unchecked")
    RpcFuture<Object> future = (RpcFuture<Object>) pendingTasks.remove(input.getRequestId());
    if (future == null) {
      LOG.error("future not found with type {}", input.getType());
      return;
    }
    future.success(o);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {}

  public void close() {
    ChannelHandlerContext ctx = context;
    if (ctx != null) {
      ctx.close();
    }
  }
}
