package com.zhout.c10简化函数调用.p14用异常取代错误码.unchecked异常;

/**
 * @author zhout
 * @date 2020/5/7 11:09
 */
class Assert {
  static void isTrue(String comment, boolean test) {
    if (!test) {
      throw new RuntimeException("Assertion failed: " + comment);
    }
  }
}
