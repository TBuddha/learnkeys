package com.zhout.c6重新组织函数.p8以函数对象取代函数;

/**
 * @author zhout
 * @date 2020/4/14 15:20
 */
public class Gamma {

  private final Account _account;
  private int inputVal;
  private int quantity;
  private int yearToDate;
  private int importantValue1;
  private int importantValue2;
  private int importantValue3;

  Gamma(Account source, int inputValArg, int quantityArg, int yearToDateArg) {
    _account = source;
    inputVal = inputValArg;
    quantity = quantityArg;
    yearToDate = yearToDateArg;
  }

  //  int compute() {
  //    importantValue1 = (inputVal * quantity) + _account.delta();
  //    importantValue2 = (inputVal * yearToDate) + 100;
  //    if ((yearToDate - importantValue1) > 100) importantValue2 -= 20;
  //    int importantValue3 = importantValue2 * 7;
  //    // and so on.
  //    return importantValue3 - 2 * importantValue1;
  //  }

  int compute1() {
    importantValue1 = (inputVal * quantity) + _account.delta();
    importantValue2 = (inputVal * yearToDate) + 100;
    importantThing();
    int importantValue3 = importantValue2 * 7;
    // and so on.
    return importantValue3 - 2 * importantValue1;
  }

  void importantThing() {
    if ((yearToDate - importantValue1) > 100) importantValue2 -= 20;
  }
}
