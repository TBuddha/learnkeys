package example.rpc.common;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhout
 * @date 2020/9/10 16:40
 */
@AllArgsConstructor
public class MessageInput {

  @Getter private String type;
  @Getter private String requestId;
  private String payload;

  // 因为想直接拿到对象，所以要提供对象的类型参数
  public <T> T getPayload(Class<T> clazz) {
    if (payload == null) {
      return null;
    }
    return JSON.parseObject(payload, clazz);
  }
}
