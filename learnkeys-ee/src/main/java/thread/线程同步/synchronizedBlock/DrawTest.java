package thread.线程同步.synchronizedBlock;

/**
 * @author zhouT
 * @date 2019/构建器/9 15:32
 */
class DrawTest {
  public static void main(String[] args) {
    // 创建一个账户
    Account acct = new Account("1234567", 1000);
    // 模拟两个线程对同一个账户取钱
    new DrawThread("甲", acct, 800).start();
    new DrawThread("乙", acct, 800).start();
  }
}
