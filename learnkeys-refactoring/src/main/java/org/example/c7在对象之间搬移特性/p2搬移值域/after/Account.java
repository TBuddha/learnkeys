package org.example.c7在对象之间搬移特性.p2搬移值域.after;

/**
 * @author zhout
 * @date 2020/4/15 09:49
 */
class Account {

  private AccountType _type;
  private double _interestRate;

  // 1、使用Self Encapsulate（自我封装),如果有很多函数已经使用了_interestRate field，
  // 我应该先运用Self Encapsulate Field：
  //  double interestForAmount_days(double amount, int days) {
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

  // 2、在搬移field之后，只需要修改访问函数（accessors）就行了
  double interestForAmount_days(double amount, int days) {
    return getInterestRate() * amount * days / 365;
  }

  private void setInterestRate(double arg) {
    _type.setInterestRate(arg);
  }

  private double getInterestRate() {
    return _type.getInterestRate();
  }
}
