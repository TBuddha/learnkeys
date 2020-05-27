package thread.线程同步.synchronizedMethod;

/**
 * @author zhouT
 * @date 2019/构建器/9 15:23
 */
class DrawThread extends Thread {
  // 模拟账户
  private Account account;
  // 当前线程所希望取的钱
  private double drawAmount;

  public DrawThread(String name, Account account, double drawAmount) {
    super(name);
    this.account = account;
    this.drawAmount = drawAmount;
  }

  // 当多个线程修改同一个共享数据时，将涉及数据安全问题
  @Override
  public void run() {
    account.draw(drawAmount);
  }
}
