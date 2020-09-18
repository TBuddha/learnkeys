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
}
