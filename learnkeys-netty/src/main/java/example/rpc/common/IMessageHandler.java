package example.rpc.common;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author zhout
 * @date 2020/9/10 10:47
 * 消息处理器接口，每个自定义服务必须实现handle方法
 */
public interface IMessageHandler<T> {

  void handle(ChannelHandlerContext ctx, String requestId, T message);
}
