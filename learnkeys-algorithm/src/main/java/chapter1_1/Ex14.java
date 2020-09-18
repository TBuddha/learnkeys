package chapter1_1;

import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:54
 */
public class Ex14 {
  // “编写一个静态方法lg() ，接受一个整型参数 N，返回不大于 log2N 的最大整数。不要 使用 Math 库”
  // 解释log2N，意义为2的多少次方等于N
  @Test
  public void test() {
    int value = 23;
    System.out.println(lg(value) + "==" + lg2(value));
  }

  // Jimmy Sun版本
  private static int lg(int n) {
    int shiftRightCount = 0;
    do {
      n >>= 1;
      shiftRightCount++;
    } while (n != 0);
    return shiftRightCount - 1;
  }

  // Kyson版本
  private static int lg2(int N) {
    int product = 1;
    int x = -1;
    while (product <= N) { // *，把等于的情况也纳入进来，从而避免了在如23>5这种情况的自增导致输出结果为3的情况
      product *= 2;
      x++;
    }
    return x;
  }
}
