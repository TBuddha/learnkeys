package thread.线程通信.sync;

/**
 * @author zhouT
 * @date 2019/构建器/11 15:00
 */
class DrawThread extends Thread {

  // 模拟账户
  private Account account;
  // 当前线程所希望取的钱
  private double drawAmount;

  DrawThread(String name, Account account, double drawAmount) {
    super(name);
    this.account = account;
    this.drawAmount = drawAmount;
  }

  // 重复100次执行取钱操作
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      account.draw(drawAmount);
    }
  }
}
