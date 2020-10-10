package chapter1_1;

import com.zhout.guava.math.Maths;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:56
 */
public class Ex18 {
  // mystery(2, 25) 和 mystery(3, 11) 的返回值是多少？给定正整数 a 和 b ，
  // mystery(a,b) 计算的结果是什么？将代码中的 + 替换为 * 并将
  // return 0 改为 return 1 ，然后回答相同的问题
  // 这道题目考了一个思想，数据和操作，即第一个参数是数据，第二个参数是操作的。这在实际编程中也是一种解耦的思想
  public static int mystery(int a, int b) {
    if (b == 0) return 0;
    if (b % 2 == 0) return mystery(a + a, b / 2);
    return mystery(a + a, b / 2) + a;
  }

  public static int mystery2(int a, int b) {
    if (b == 0) return 1;
    if (b % 2 == 0) return mystery2(a * a, b / 2);
    return mystery2(a * a, b / 2) * a;
  }

  @Test
  public void test() {
    Assert.assertEquals(mystery(2, 25), 50);
    Assert.assertEquals(mystery(3, 11), 33);
    // 结果为a*b

    Assert.assertEquals(mystery2(2, 25), 33554432);
    Assert.assertEquals(mystery2(3, 11), 177147);
    // 结果为a^b

    Assert.assertEquals(Maths.loga(2, 33554432), 25, 0);
    Assert.assertEquals(Maths.loga(3, 177147), 11, 0);
  }
}
