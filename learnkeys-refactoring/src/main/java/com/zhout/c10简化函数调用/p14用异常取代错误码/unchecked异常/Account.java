package com.zhout.c10简化函数调用.p14用异常取代错误码.unchecked异常;

/**
 * 现实生活中你可以透支你的账户余额，计算器教科书却总是假设你不能这样做，这不是报奇怪吗？不过下而的例子仍然假设你不能这样做：
 *
 * @author zhout
 * @date 2020/5/7 10:40
 */
class Account {
  int withdraw(int amount) {
    if (amount > _balance) return -1;
    else {
      _balance -= amount;
      return 0;
    }
  }

  private int _balance;
}
