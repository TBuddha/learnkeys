package com.zhout.c10简化函数调用.p14用异常取代错误码.unchecked异常;

/**
 * 现实生活中你可以透支你的账户余额，计算器教科书却总是假设你不能这样做，这不是报奇怪吗？不过下而的例子仍然假设你不能这样做：
 *
 * @author zhout
 * @date 2020/5/7 10:40
 */
class Account {
  //  int withdraw(int amount) {
  //    if (amount > _balance) return -1;
  //    else {
  //      _balance -= amount;
  //      return 0;
  //    }
  //  }

  // 1、现在，我需要移除错误码，并在程序出错时抛出异常。
  // 由于行为（根据其文本定义 得知）是异常的、罕见的，所以我应该用一个卫语句（guard clause）检查这种情况：
  //  void withdraw(int amount) {
  //    if (amount > _balance) throw new IllegalArgumentException("Amount too large");
  //    _balance -= amount;
  //  }

  // 2、由于这是程序员所犯的错误，所以我应该使用assertion 更清楚地指出这一点：
  void withdraw(int amount) {
    Assert.isTrue("amount too large", amount > _balance);
    _balance -= amount;
  }

  boolean canWithdraw(int amount) {
    return false;
  }

  private int _balance;
}
