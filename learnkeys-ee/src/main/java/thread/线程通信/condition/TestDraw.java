package thread.线程通信.condition;

/**
 * @author zhouT
 * @date 2019/构建器/11 17:52
 */
class TestDraw {
  public static void main(String[] args) {
    // 创建一个账户
    Account acct = new Account("1234567", 0);
    new DrawThread("取钱者", acct, 8800).start();
    new DepositThread("存钱者甲", acct, 8800).start();
    new DepositThread("存钱者乙", acct, 8800).start();
    new DepositThread("存钱者丙", acct, 8800).start();
  }
}
