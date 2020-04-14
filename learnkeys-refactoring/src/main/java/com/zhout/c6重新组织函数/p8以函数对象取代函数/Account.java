package com.zhout.c6重新组织函数.p8以函数对象取代函数;

/**
 * @author zhout
 * @date 2020/4/14 15:18
 */
public class Account {

  int delta() {
    return -1;}

  //  int gamma(int inputVal, int quantity, int yearToDate) {
  //    int importantValue1 = (inputVal * quantity) + delta();
  //    int importantValue2 = (inputVal * yearToDate) + 100;
  //    if ((yearToDate - importantValue1) > 100) importantValue2 -= 20;
  //    int importantValue3 = importantValue2 * 7;
  //    // and so on.
  //    return importantValue3 - 2 * importantValue1;
  //  }

  int gamma1 (int inputVal, int quantity, int yearToDate) {
    return new Gamma(this, inputVal, quantity, yearToDate).compute1();
  }
}
