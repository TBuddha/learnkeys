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
    Assert.assertEquals(toBinaryString(value), Integer.toBinaryString(value));
  }

  private String toBinaryStr(int N) {
    String s = "";
    for (int n = N; n > 0; n /= 2) s = (n % 2) + s;
    return s;
  }

  /** 此方法支持正负整数 */
  private static String toBinaryString(int value) {
    if (value == 0) {
      return "0";
    }
    int bufLen = 32;
    int index = bufLen;
    char[] result = new char[bufLen];
    do {
      // 使用 & 符合相对除 2 提升一定性能
      result[--index] = (char) ('0' + (value & 1));
      value = value >>> 1;
    } while (value != 0);
    return new String(result, index, bufLen - index);
  }
}
