package org.example.c7在对象之间搬移特性.p1搬移函数和值域;

/**
 * @author zhout
 * @date 2020/5/13 17:55
 */
class Account {
  double overdraftCharge() { // 译注：透支金计费，它和其他class的关系似乎比较密切。
    if (_type.isPremium()) {
      double result = 10;
      if (_daysOverdrawn > 7) result += (_daysOverdrawn - 7) * 0.85;
      return result;
    } else return _daysOverdrawn * 1.75;
  }

  double bankCharge() {
    double result = 4.5;
    if (_daysOverdrawn > 0) result += overdraftCharge();
    return result;
  }

  private AccountType _type;
  private int _daysOverdrawn;
}
