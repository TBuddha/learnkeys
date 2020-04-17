package com.zhout.c7在对象之间搬移特性.p1搬移函数和值域;

/**
 * @author zhout
 * @date 2020/4/15 09:28
 */
public class AccountType {

  double overdraftCharge(int daysOverdrawn) {
    if (isPremium()) {
      double result = 10;
      if (daysOverdrawn > 7) result += (daysOverdrawn - 7) * 0.85;
      return result;
    } else return daysOverdrawn * 1.75;
  }

    /**下一章p2搬移值域*/
//  double overdraftCharge(Account account) {
//    if (isPremium()) {
//      double result = 10;
//      if (account.getDaysOverdrawn() > 7)
//        result += (account.getDaysOverdrawn() - 7) * 0.85;
//      return result;
//    }
//    else return account.getDaysOverdrawn() * 1.75;
//  }

  boolean isPremium() {
    return true;
  }
}
