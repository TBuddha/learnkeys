package com.zhout.c6重新组织函数.p7移除对参数的赋值动作;

/**
 * @author zhout
 * @date 2020/4/14 10:56
 */
public class Demo {

  int discount(int inputVal, int quantity, int yearToDate) {
    if (inputVal > 50) inputVal -= 2;
    return inputVal;
  }

  // 你的代码对一个参数进行赋值动作。
  // 以一个临时变量取代该参数的位置。
  int discount2(int inputVal, int quantity, int yearToDate) {
    int result = inputVal;
    if (inputVal > 50) result -= 2;
    return inputVal;
  }

  void aMethod(Object foo) {
    // foo.modifyInSomeWay(); // that's OK
    // foo = anotherObject; // trouble and despair will follow you
  }
}
