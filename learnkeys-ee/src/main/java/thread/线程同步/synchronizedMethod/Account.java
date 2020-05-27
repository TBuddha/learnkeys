package thread.线程同步.synchronizedMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhouT
 * @date 2019/构建器/9 15:17
 */
@NoArgsConstructor
@AllArgsConstructor
class Account {
  @Setter @Getter private String accountNo;
  // 由于余额不允许随意修改，所以只提供了getter方法
  @Getter private double balance;

  // 提供一个线程安全的draw()方法来完成取钱操作
  public synchronized void draw(double drawAmount) {
    if (balance >= drawAmount) {
      System.out.println(Thread.currentThread().getName() + "成功！吐出钞票：" + drawAmount);
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // 修改余额
      balance -= drawAmount;
      System.out.println("\t余额为：" + balance);
    } else {
      System.out.println(Thread.currentThread().getName() + "失败！余额不足");
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
