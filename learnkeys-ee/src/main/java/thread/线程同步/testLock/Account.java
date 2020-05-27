package thread.线程同步.testLock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouT
 * @date 2019/构建器/9 15:17
 */
@NoArgsConstructor
@AllArgsConstructor
public class Account {
  // 定义锁对象
  private ReentrantLock lock = new ReentrantLock();

  @Setter @Getter private String accountNo;
  // 由于余额不允许随意修改，所以只提供了getter方法
  @Getter private double balance;

  public void draw(double drawAmount) {
    // 加锁
    lock.lock();
    try {
      if (balance >= drawAmount) {
        System.out.println(Thread.currentThread().getName() + "成功！吐出钞票：" + drawAmount);
        try {
          Thread.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        // 修改余额
        balance -= drawAmount;
        System.out.println("\t余额为：" + balance);
      } else {
        System.out.println(Thread.currentThread().getName() + "失败！余额不足");
      }
    } finally {
      // 修改完成，释放锁
      lock.unlock();
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
