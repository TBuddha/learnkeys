package example.rpc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhout
 * @date 2020/9/10 16:39
 */
public class MessageHandlers {

  private Map<String, IMessageHandler<?>> handlers = new HashMap<>();
  private IMessageHandler<MessageInput> defaultHandler;

  public void register(String type, IMessageHandler<?> handler) {
    handlers.put(type, handler);
  }

  public MessageHandlers defaultHandler(IMessageHandler<MessageInput> defaultHandler) {
    this.defaultHandler = defaultHandler;
    return this;
  }

  public IMessageHandler<MessageInput> defaultHandler() {
    return defaultHandler;
  }

  public IMessageHandler<?> get(String type) {
    IMessageHandler<?> handler = handlers.get(type);
    return handler;
  }
}
