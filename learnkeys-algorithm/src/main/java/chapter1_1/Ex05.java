package chapter1_1;

import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:51
 */
public class Ex05 {
  // “编写一段程序，如果 double 类型的变量 x 和 y 都严格位于 0 和 1 之间则打印 true ，否则打印 false 。”
  @Test
  public void test() {
    double x = 1.11;
    double y = 0.555;
    System.out.println(x > 0 && x < 1 && y > 0 && y < 1);
  }
}
