package example.rpc.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhout
 * @date 2020/9/10 10:42
 */
// 指数RPC的输出
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpResponse {
  private long value;
  private long costInNanos;
}
