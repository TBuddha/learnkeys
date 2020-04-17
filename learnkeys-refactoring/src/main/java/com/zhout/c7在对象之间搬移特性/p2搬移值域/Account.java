package com.zhout.c7在对象之间搬移特性.p2搬移值域;

/**
 * @author zhout
 * @date 2020/4/15 09:49
 */
public class Account {

  private AccountType _type;
  private double _interestRate;

  double interestForAmount_days(double amount, int days) {
    return _interestRate * amount * days / 365;
  }

  double interestForAmount_days1(double amount, int days) {
    return _type.getInterestRate() * amount * days / 365;
  }

  /** 使用Self Encapsulate（自我封装),如果有很多函数已经使用了_interestRate field，我应该先运用Self Encapsulate Field： */
  //  double interestForAmount_days2(double amount, int days) {
  //    return getInterestRate() * amount * days / 365;
  //  }
  //
  //  private void setInterestRate(double arg) {
  //    _interestRate = arg;
  //  }
  //
  //  private double getInterestRate() {
  //    return _interestRate;
  //  }

  /** 在搬移field之后，只需要修改访问函数（accessors）就行了****** */
  double interestForAmount_days2(double amount, int days) {
    return getInterestRate() * amount * days / 365;
  }

  private void setInterestRate(double arg) {
    _type.setInterestRate(arg);
  }

  private double getInterestRate() {
    return _type.getInterestRate();
  }
}
