package org.example.c7在对象之间搬移特性.p1搬移函数和值域.after;

/**
 * @author zhout
 * @date 2020/4/15 09:28
 */
class AccountType {

  double overdraftCharge(int daysOverdrawn) {
    if (isPremium()) {
      double result = 10;
      if (daysOverdrawn > 7) result += (daysOverdrawn - 7) * 0.85;
      return result;
    } else return daysOverdrawn * 1.75;
  }

  // 此例之中被移函数只取用（指涉〕一个值域，所以我只需将这个值域作为参数传给target
  // method就行了。如果被移函数调用了Account中的另一个函数，我就不能这么简单地处理。
  // 这种情况下我必须将source object传递给target method
  /** 未完成，代码在下一章p2搬移值域 */
  //    double overdraftCharge(Account account) {
  //      if (isPremium()) {
  //        double result = 10;
  //        if (account.getDaysOverdrawn() > 7)
  //          result += (account.getDaysOverdrawn() - 7) * 0.85;
  //        return result;
  //      }
  //      else return account.getDaysOverdrawn() * 1.75;
  //    }

  boolean isPremium() {
    return true;
  }
}
