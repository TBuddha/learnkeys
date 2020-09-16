package p6QA;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/15 10:12
 */
public class Question {

  // “Math.abs(-2147483648) 的返回值是什么？”
  @Test
  public void answer1() {
    // Math.abs用于取绝对值
    // 这里的答案为-2147483648 。这个奇怪的结果（但的确是真的）就是整数溢出的典型例子。
    Assert.assertEquals(-2147483648, Math.abs(-2147483648));
  }

  // “如何才能将一个 double 变量初始化为无穷大？”
  @Test
  public void answer2() {
    System.out.println(Double.POSITIVE_INFINITY);
    System.out.println(Double.NEGATIVE_INFINITY);
    Assert.assertTrue(Double.isInfinite(Double.POSITIVE_INFINITY));
    Assert.assertTrue(Double.isInfinite(Double.NEGATIVE_INFINITY));
  }

  // 取余
  @Test
  public void answer3() {
    Assert.assertEquals(5 / 3,1);
    Assert.assertEquals(5 % 3,2);
    Assert.assertEquals((5 / 3) * 3,3);

    // a % b 的余数的定义是 (a/b)*b + a % b 恒等于 a
    Assert.assertEquals((5 / 3) * 3 + 5 % 3, 5);
  }
}
