package thread.线程通信.sync;

/**
 * @author zhouT
 * @date 2019/构建器/11 15:03
 */
public class DepositThread extends Thread {

  // 模拟账户
  private Account account;
  // 当前存款线程所希望存的钱
  private double depositAmount;

  DepositThread(String name, Account account, double depositAmount) {
    super(name);
    this.account = account;
    this.depositAmount = depositAmount;
  }

  // 重复100次执行存款操作
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      account.deposit(depositAmount);
    }
  }
}
