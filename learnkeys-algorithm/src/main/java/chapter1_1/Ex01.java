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
    Assert.assertEquals((0 + 15) / 2, 7); // 类型是整形，所以输出7
    Assert.assertEquals(2.0e-6 * 100000000.1, 200.0000002, 0); // 浮点型
    Assert.assertTrue(true && false || true && true); // false||true，输出
  }
}
