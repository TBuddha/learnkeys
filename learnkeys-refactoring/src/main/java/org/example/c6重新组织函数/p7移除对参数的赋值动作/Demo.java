package org.example.c6重新组织函数.p7移除对参数的赋值动作;

/**
 *
 * 你的代码对一个参数进行赋值动作。 以一个临时变量取代该参数的位置。
 * @author zhout
 * @date 2020/4/14 10:56
 */
class Demo {

  int discount(int inputVal, int quantity, int yearToDate) {
    if (inputVal > 50) inputVal -= 2;
    return inputVal;
  }

  int discount2(int inputVal, int quantity, int yearToDate) {
    int result = inputVal;
    if (inputVal > 50) result -= 2;
    return inputVal;
  }

  //-----------------例2------------------//

  void aMethod(Object foo) {
    // that's OK
    // foo.modifyInSomeWay();

    // 麻烦和绝望会跟着你
    // foo = anotherObject;
  }
}
