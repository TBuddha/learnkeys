package chapter1_1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:55
 */
public class Ex16 {
  // “给出 exR1(6) 的返回值”
  @Test
  public void test() {
    Assert.assertEquals(exR1(6), "311361142246");
  }

  public static String exR1(int n) {
    if (n <= 0) return "";
    return exR1(n - 3) + n + exR1(n - 2) + n;
  }
  // 解：
  // exR1(6) = exR1(3) + 6 + exR1(4) + 6
  // exR1(4) = exR1(1) + 4 + exR1(2) + 4 = "114224"
  // exR1(3) = exR1(0) + 3 + exR1(1) + 3 = "3113”
  // exR1(2) = exR1(-1) + 2 + exR1(0) + 2 = "22"
  // exR1(1) = exR1(-2) + 1 + exR1(-1) + 1 = "11"
  // n < 1时，exR1(n) = ""
  // 故 exR1(6) = "311361142246"
}
