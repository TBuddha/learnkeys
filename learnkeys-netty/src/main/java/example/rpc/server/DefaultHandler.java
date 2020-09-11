package example.rpc.server;

import example.rpc.common.IMessageHandler;
import example.rpc.common.MessageInput;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhout
 * @date 2020/9/10 16:45
 */
public class DefaultHandler implements IMessageHandler<MessageInput> {

  private final static Logger LOG = LoggerFactory.getLogger(DefaultHandler.class);

  // 找不到类型的消息统一使用默认处理器处理
  @Override
  public void handle(ChannelHandlerContext ctx, String requestId, MessageInput input) {
    LOG.error("unrecognized message type {} comes", input.getType());
    ctx.close();
  }
}
