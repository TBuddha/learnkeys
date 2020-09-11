package example.rpc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhout
 * @date 2020/9/10 16:43
 */
public class MessageRegistry {
  private Map<String, Class<?>> clazzes = new HashMap<>();

  public void register(String type, Class<?> clazz) {
    clazzes.put(type, clazz);
  }

  public Class<?> get(String type) {
    return clazzes.get(type);
  }
}
