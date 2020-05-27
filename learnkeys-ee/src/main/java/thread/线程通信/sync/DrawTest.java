package thread.线程通信.sync;

/**
 * @author zhouT
 * @date 2019/构建器/11 15:06
 */
public class DrawTest {
  public static void main(String[] args) {
    // 创建账户
    Account account = new Account("123456", 0);
    new DrawThread("取钱者", account, 800).start();
    new DepositThread("存款者甲", account, 800).start();
    new DepositThread("存款者乙", account, 800).start();
    new DepositThread("存款者丙", account, 800).start();
  }
}
