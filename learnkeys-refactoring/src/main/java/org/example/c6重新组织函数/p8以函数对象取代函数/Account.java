package org.example.c6重新组织函数.p8以函数对象取代函数;

/**
 * 如果要给这一重构手法找个合适例子，需要很长的篇幅。
 * 所以我以一个不需要长篇幅（那也就是说可能不十分完美）的例子展示这项重构。请不要问这个函数的逻辑是什么，这完全是我且战且走的产品。
 *
 * @author zhout
 * @date 2020/4/14 15:18
 */
class Account {

  int gamma(int inputVal, int quantity, int yearToDate) {
    int importantValue1 = (inputVal * quantity) + delta();
    int importantValue2 = (inputVal * yearToDate) + 100;
    if ((yearToDate - importantValue1) > 100) importantValue2 -= 20;
    int importantValue3 = importantValue2 * 7;
    // and so on.
    return importantValue3 - 2 * importantValue1;
  }

  //1、修改旧函数，让它将它的工作转发〔委托，delegate）给刚完成的这个函 数对象（method object
  int gamma1(int inputVal, int quantity, int yearToDate) {
    return new Gamma(this, inputVal, quantity, yearToDate).compute1();
  }

  int delta() {
    return -1;
  }
}
