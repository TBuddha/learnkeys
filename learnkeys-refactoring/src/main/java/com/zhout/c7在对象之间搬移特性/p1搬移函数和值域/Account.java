package com.zhout.c7在对象之间搬移特性.p1搬移函数和值域;

/**
 * @author zhout
 * @date 2020/4/15 09:27
 */
public class Account {

  private AccountType _type;
  private int _daysOverdrawn;

  double overdraftCharge() { // 译注：透支金计费，它和其他class的关系似乎比较密切。
    if (_type.isPremium()) {
      double result = 10;
      if (_daysOverdrawn > 7) result += (_daysOverdrawn - 7) * 0.85;
      return result;
    } else return _daysOverdrawn * 1.75;
  }

  // 替换为一个简单的委托动作（delegation)
  double overdraftCharge1() {
    return _type.overdraftCharge(_daysOverdrawn);
  }

  double bankCharge() {
    double result = 4.5;
    if (_daysOverdrawn > 0) result += overdraftCharge();
    return result;
  }

  double bankCharge1() {
    double result = 4.5;
    if (_daysOverdrawn > 0) result += _type.overdraftCharge(_daysOverdrawn);
    return result;
  }
}
