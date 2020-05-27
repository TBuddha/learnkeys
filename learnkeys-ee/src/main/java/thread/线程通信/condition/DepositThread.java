package thread.线程通信.condition;

/**
 * @author zhouT
 * @date 2019/构建器/11 17:51
 */
public class DepositThread extends Thread {
  // 模拟用户账户
  private Account account;
  // 当前取钱线程所希望取的钱数
  private double depositAmount;

  public DepositThread(String name, Account account, double depositAmount) {
    super(name);
    this.account = account;
    this.depositAmount = depositAmount;
  }

  // 当多条线程修改同一个共享数据时，将涉及到数据安全问题。
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      account.deposit(depositAmount);
    }
  }
}
