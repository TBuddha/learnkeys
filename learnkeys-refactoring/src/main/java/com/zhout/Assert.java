package com.zhout;

/**
 * @author zhout
 * @date 2020/5/7 16:15
 */
public class Assert {

  public static final boolean ON = true;
  public static final boolean OFF = false;

  public static void isTrue(boolean condition) {
    if (!condition) {
      throw new RuntimeException("Assertion failed");
    }
  }

  public static void isTrue(String comment, boolean test) {
    if (!test) {
      throw new RuntimeException("Assertion failed: " + comment);
    }
  }

  public static void shouldNeverReachHere(String message) {
    throw new RuntimeException(message);
  }
}
