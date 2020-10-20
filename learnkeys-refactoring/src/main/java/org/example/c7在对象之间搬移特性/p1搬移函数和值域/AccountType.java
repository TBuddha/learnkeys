package org.example.c7在对象之间搬移特性.p1搬移函数和值域;

/**
 * @author zhout
 * @date 2020/5/13 17:56
 */
class AccountType {

  double overdraftCharge(int daysOverdrawn) {
    if (isPremium()) {
      double result = 10;
      if (daysOverdrawn > 7) result += (daysOverdrawn - 7) * 0.85;
      return result;
    } else return daysOverdrawn * 1.75;
  }

  boolean isPremium() {
    return true;
  }
}
