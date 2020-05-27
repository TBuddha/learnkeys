package thread.线程同步.synchronizedBlock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouT
 * @date 2019/构建器/9 15:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class Account {
  private String accountNo;
  private double balance;

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
