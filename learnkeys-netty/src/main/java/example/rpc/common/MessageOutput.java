package example.rpc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhout
 * @date 2020/9/10 10:59
 */
@AllArgsConstructor
@Getter
public class MessageOutput {
  private String requestId;
  private String type;
  private Object payload;
}
