package com.zhout.c10简化函数调用.p14用异常取代错误码.unchecked异常;

/**
 * @author zhout
 * @date 2020/5/7 10:44
 */
class Client {

  Account account;
  int amount;

  public void test() {
    if (account.withdraw(amount) == -1) handleOverdrawn();
    else doTheUsualThing();
  }

  // 处理透支
  void handleOverdrawn() {}

  // 做平常的事
  void doTheUsualThing() {}

  public static void main(String[] args) {

  }
}
