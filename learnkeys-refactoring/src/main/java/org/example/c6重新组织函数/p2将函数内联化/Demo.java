package org.example.c6重新组织函数.p2将函数内联化;

/**
 * 一个函数，其本体（method body）应该与其名称（method name)同样清楚易懂。
 * @author zhout
 * @date 2020/4/14 14:28
 */
class Demo {

  private int _numberOfLateDeliveries;

  int getRating() {
    return (moreThanFiveLateDeliveries()) ? 2 : 1;
  }

  // 在函数调用点插入函数本体，然后移除该函数。
  int getRating1() {
    return (_numberOfLateDeliveries > 5) ? 2 : 1;
  }

  boolean moreThanFiveLateDeliveries() {
    return _numberOfLateDeliveries > 5;
  }
}
