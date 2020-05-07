package com.zhout.c10简化函数调用.p14用异常取代错误码.unchecked异常;

/**
 * @author zhout
 * @date 2020/5/7 10:44
 */
class Client {

  Account account;
  int amount;

  // 首先考虑unchecked 异常。使用这个东西就表示应该由调用者负责检查。首先我需要检查调用端的代码，它不应该使用withdraw()
  // 函数的返回值，因为该返回值只用来指出程序员的错误。如果我看到下面这样的代码：
  //  public void demo() {
  //    if (account.withdraw(amount) == -1) handleOverdrawn();
  //    else doTheUsualThing();
  //  }
  // 我应该将它替换为这样的代码：
  public void demo1() {
    if (!account.canWithdraw(amount)) handleOverdrawn();
    else {
      account.withdraw(amount);
      doTheUsualThing();
    }
  }

  // 处理透支
  void handleOverdrawn() {}

  // 做平常的事
  void doTheUsualThing() {}
}
