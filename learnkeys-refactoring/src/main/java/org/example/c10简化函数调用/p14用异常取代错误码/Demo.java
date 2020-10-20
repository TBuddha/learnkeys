package org.example.c10简化函数调用.p14用异常取代错误码;

/**
 * 某个函数返回一个特定的代码（special code），用以表示某种错误情况。 改用异常（exception）
 *
 * @author zhout
 * @date 2020/5/7 10:33
 */
class Demo {
  int withdraw(int amount) {
    if (amount > _balance) return -1;
    else {
      _balance -= amount;
      return 0;
    }
  }

  // =>

  void withdraw1(int amount) throws BalanceException {
    if (amount > _balance) throw new BalanceException();
    _balance -= amount;
  }

  int _balance;
}
