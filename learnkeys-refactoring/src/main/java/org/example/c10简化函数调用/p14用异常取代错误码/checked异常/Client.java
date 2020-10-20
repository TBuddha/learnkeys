package org.example.c10简化函数调用.p14用异常取代错误码.checked异常;

/**
 * @author zhout
 * @date 2020/5/7 11:12
 */
class Client {

  Account account;
  int amount;

  public void demo() {
    //    try {
    //      account.withdraw(amount);
    //      doTheUsualThing();
    //    } catch (BalanceException e) {
    //      handleOverdrawn();
    //    }
    // 现在我可以逐一将「对旧函数的调用」替换为「对新函数 的调用」
    try {
      account.newWithdraw(amount);
      doTheUsualThing();
    } catch (BalanceException e) {
      handleOverdrawn();
    }
  }

  // 处理透支
  void handleOverdrawn() {}

  // 做平常的事
  void doTheUsualThing() {}
}
