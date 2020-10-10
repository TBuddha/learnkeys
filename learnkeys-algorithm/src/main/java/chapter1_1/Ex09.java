package chapter1_1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:53
 */
public class Ex09 {
  // “编写一段代码，将一个正整数 N 用二进制表示并转换为一个 String 类型的值 s ”
  // Java 有一个内置方法 Integer.toBinaryString(N) 专门完成这个任务，
  // 但该题的目的就是给出这个方法的其他实现方法。下面就是一个特别简洁的答案：
  @Test
  public void test() {
    int N = 1024;
    Assert.assertEquals(toBinaryStr(N), Integer.toBinaryString(N));

    int value = -1024;
    Assert.assertEquals(decimalToBinary(value), Integer.toBinaryString(value));
  }

  private String toBinaryStr(int N) {
    String s = "";
    for (int n = N; n > 0; n /= 2) s = (n % 2) + s;
    return s;
  }
  // 分析：虽然够简洁，但效率不怎么样，Java源码的的实现效率可以，Java Integer
  // 源码：http://grepcode.com/file_/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/lang/Integer.java/?v=source
  /** 此方法支持正负整数 */
  public static String decimalToBinary(int n) {
    String resultString = "";
    for (int i = 31; i >= 0; i--) resultString = resultString + (n >>> i & 1);
    return resultString;
  }
}
