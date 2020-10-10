package chapter1_1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:50
 */
public class Ex02 {

  @Test
  public void test() {
    // 这里需要解释一下，第一题因为0和15都是整型变量，所以结果是整型。
    // 而这里整型和浮点型相加，JVM会自动将整形转为浮点型。
    // 另：如果要精确的小数计算的话，建议使用BigDecimal
    Assert.assertEquals((1 + 2.236) / 2, 1.618, 0.000);

    //1，2，3会转换为浮点型
    Assert.assertEquals(1 + 2 + 3 + 4.0, 10.0, 0);

    Assert.assertTrue(4.1 >= 4);

    // !!!//数字转化为字符串
    Assert.assertEquals(1 + 2 + "3", "33");
  }
}
