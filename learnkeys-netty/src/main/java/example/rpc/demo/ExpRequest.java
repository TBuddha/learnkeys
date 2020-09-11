package example.rpc.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhout
 * @date 2020/9/10 10:41
 */

// 指数RPC的输入
@Data
@AllArgsConstructor
public class ExpRequest {
  private int base;
  private int exp;
}
