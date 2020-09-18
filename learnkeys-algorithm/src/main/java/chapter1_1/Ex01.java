package chapter1_1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:49
 */
public class Ex01 {
  @Test
  public void test() {
    Assert.assertEquals((0 + 15) / 2, 7);
    Assert.assertEquals(2.0e-6 * 100000000.1, 200.0000002, 0);
    Assert.assertTrue(true && false || true && true);
  }
}
