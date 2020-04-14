package com.zhout.c6重新组织函数.p2将函数内联化;

/**
 * @author zhout
 * @date 2020/4/14 14:28
 */
public class Demo {
  private int _numberOfLateDeliveries;

  int getRating() {
    return (moreThanFiveLateDeliveries()) ? 2 : 1;
  }

  boolean moreThanFiveLateDeliveries() {
    return _numberOfLateDeliveries > 5;
  }

  // final
  int getRating2() {
    return (_numberOfLateDeliveries > 5) ? 2 : 1;
  }
}
