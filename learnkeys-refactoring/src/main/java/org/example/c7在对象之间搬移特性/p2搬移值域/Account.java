package org.example.c7在对象之间搬移特性.p2搬移值域;

/**
 * @author zhout
 * @date 2020/5/13 18:04
 */
class Account {

  private AccountType _type;
  private double _interestRate;

  double interestForAmount_days(double amount, int days) {
    //return _interestRate * amount * days / 365;
    return _type.getInterestRate() * amount * days / 365;
  }
}
