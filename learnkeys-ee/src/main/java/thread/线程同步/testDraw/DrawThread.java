package thread.线程同步.testDraw;

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
    if (account.getBalance() >= drawAmount) {
      System.out.println(getName() + "成功！吐出钞票：" + drawAmount);
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // 修改余额
      account.setBalance(account.getBalance() - drawAmount);
      System.out.println("\t余额为：" + account.getBalance());
    } else {
      System.out.println(getName() + "失败，余额不足");
    }
  }
}
