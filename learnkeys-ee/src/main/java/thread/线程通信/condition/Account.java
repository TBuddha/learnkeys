package thread.线程通信.condition;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouT
 * @date 2019/构建器/11 17:37
 */
public class Account {

  // 显式定义lock对象
  private final Lock lock = new ReentrantLock();
  // 获得指定lock对象对应的Condition
  private final Condition condition = lock.newCondition();

  @Setter @Getter private String accountNo;
  // 由于余额不允许随意修改，所以只提供了getter方法
  @Getter private double balance;

  // 账户中是否已有存款的标志位
  private boolean flag = false;

  public Account(String accountNo, double balance) {
    this.accountNo = accountNo;
    this.balance = balance;
  }

  public void draw(double drawAmount) {
    // 加锁
    lock.lock();
    try {
      // 为假，说明账户中还没有人存钱进去，取钱方法阻塞
      if (!flag) {
        condition.await();
      } else {
        // 执行取钱操作
        System.out.println(Thread.currentThread().getName() + "取钱：" + drawAmount);
        balance -= drawAmount;
        System.out.println("账户余额为：" + balance);
        // 标识账户中是否已有存款的状态
        flag = false;
        // 唤醒其他线程
        condition.signalAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      // 使用finally来释放锁
      lock.unlock();
    }
  }

  public void deposit(double depositAmount) {
    // 加锁
    lock.lock();
    try {
      // 为真，说明账户中已有人存钱进去，存钱方法阻塞
      if (flag) {
        condition.await();
      } else {
        // 执行存款操作
        System.out.println(Thread.currentThread().getName() + "存钱：" + depositAmount);
        balance += depositAmount;
        System.out.println("账户余额为：" + balance);
        // 将标识账户中是否已有存款的标志位设为true
        flag = true;
        // 唤醒其他线程
        condition.signalAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      // 使用finally来释放锁
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
