package com.zhout.c6重新组织函数.p7移除对参数的赋值动作;

/**
 * @author zhout
 * @date 2020/4/14 14:52
 */
class Demo2 {

  int discount(int inputVal, int quantity, int yearToDate) {
    if (inputVal > 50) inputVal -= 2;
    if (quantity > 100) inputVal -= 1;
    if (yearToDate > 10000) inputVal -= 4;
    return inputVal;
  }

  // 以临时变量取代对参数的赋值动作，得到下列代码：
  int discount2(int inputVal, int quantity, int yearToDate) {
    int result = inputVal;
    if (inputVal > 50) result -= 2;
    if (quantity > 100) result -= 1;
    if (yearToDate > 10000) result -= 4;
    return result;
  }

  // 还可以为参数加上关键词final，从而强制它遵循「不对参数赋值」这一惯例：
  int discount3(final int inputVal, final int quantity, final int yearToDate) {
    int result = inputVal;
    if (inputVal > 50) result -= 2;
    if (quantity > 100) result -= 1;
    if (yearToDate > 10000) result -= 4;
    return result;
  }


}
