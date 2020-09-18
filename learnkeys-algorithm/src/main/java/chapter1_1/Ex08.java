package chapter1_1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:52
 */
public class Ex08 {
  @Test
  public void test() {
    Assert.assertEquals('b', 'b'); // 直接打印char字符
    Assert.assertEquals('b' + 'c', 197); // 98 + 99 = 197
    Assert.assertEquals((char) ('a' + 4), 101); // 97 + 4 = 101，e的ASCII码是101
  }
}
