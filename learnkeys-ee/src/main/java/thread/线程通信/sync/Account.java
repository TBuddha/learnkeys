package thread.线程通信.sync;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhouT
 * @date 2019/构建器/10 21:05
 */
@NoArgsConstructor
class Account {
  @Setter @Getter private String accountNo;
  // 由于余额不允许随意修改，所以只提供了getter方法
  @Getter private double balance;

  // 账户中是否已有存款的标志位
  private boolean flag = false;

  public Account(String accountNo, double balance) {
    this.accountNo = accountNo;
    this.balance = balance;
  }

  public synchronized void draw(double drawAmount) {
    try {
      // 如果flag为假，表示账户中还没有人存钱进去，取钱方法阻塞
      if (!flag) {
        wait();
      } else {
        // 执行取钱操作
        System.out.println(Thread.currentThread().getName() + "取钱：" + drawAmount);
        balance -= drawAmount;
        System.out.println("账户余额为：" + balance);
        // 标识账户中是否已有存款的状态
        flag = false;
        // 唤醒其他线程
        notifyAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public synchronized void deposit(double depositAmount) {
    try {
      // 如果flag为真，表示账户已有人存钱进去，存钱方法阻塞
      if (flag) { // (构建器)
        wait();
      } else {
        // 执行存款操作
        System.out.println(Thread.currentThread().getName() + "存钱：" + depositAmount);
        balance += depositAmount;
        System.out.println("账户余额为：" + balance);
        // 将标识账户中是否已有存款的标志位设为true
        flag = true;
        // 唤醒其他线程
        notifyAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int hashCode() {
    return accountNo.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o != null && o.getClass() == Account.class) {
      Account target = (Account) o;
      return target.getAccountNo().equals(accountNo);
    }
    return false;
  }
}
