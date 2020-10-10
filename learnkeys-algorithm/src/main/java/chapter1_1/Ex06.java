package chapter1_1;

import org.junit.Test;
import repo.StdOut;

/**
 * @author zhout
 * @date 2020/9/16 16:52
 */
public class Ex06 {
  // “下面这段程序会打印出什么”
  @Test
  public void ex6() {
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }
  // 输出
  // 0
  // 1
  // 1
  // 2
  // 3
  // 5
  // 8
  // 13
  // 21
  // 34
  // 55
  // 89
  // 144
  // 233
  // 377
  // 610
  // 所以这段代码是用来展示 斐波那契数列 的
}
