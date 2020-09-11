package example.rpc.common;

import java.util.UUID;

/**
 * @author zhout
 * @date 2020/9/10 17:04
 */
public class RequestId {
  public static String next() {
    return UUID.randomUUID().toString();
  }
}
