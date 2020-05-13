package com.zhout.c7在对象之间搬移特性.p1搬移函数和值域.after;

/**
 * @author zhout
 * @date 2020/4/15 09:27
 */
class Account {

  private AccountType _type;
  private int _daysOverdrawn;

  // 替换为一个简单的委托动作（delegation)
  double overdraftCharge() {
    return _type.overdraftCharge(_daysOverdrawn);
  }

  // 可以保留代码如今的样子，也可以删除source method。如果决定删除，就得找出source
  // method的所有调用者，并将这些调用重新定向，改调用Account的bankCharge()：
  double bankCharge() {
    double result = 4.5;
    if (_daysOverdrawn > 0) result += _type.overdraftCharge(_daysOverdrawn);
    return result;
  }
}
