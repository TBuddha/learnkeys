package org.example.c10简化函数调用.p14用异常取代错误码.checked异常;

/**
 * @author zhout
 * @date 2020/5/7 11:12
 */
class Account {

  // 1、接下来我要修改withdraw() 函数，让它以异常表示错误状况：
  //  void withdraw(int amount) throws BalanceException {
  //    if (amount > _balance) throw new BalanceException();
  //    _balance -= amount;
  //  }

  // 2、这个过程的麻烦在于：我必须一次性修改所有调用者和被它们调用的函数，否则编译器会报错。
  // 如果调用者很多，这个步骤就实在太大了，其中没有编译和测试的保障。
  // 这种情况下，我可以借助一个临时中间函数。我仍然从先前相同的情况出发
  //  int withdraw(int amount) {
  //    if (amount > _balance) return -1;
  //    else {
  //      _balance -= amount;
  //      return 0;
  //    }
  //  }

  // 3、首先，产生一个newWithdraw() 函数，让它抛出异常：
  void newWithdraw(int amount) throws BalanceException {
    if (amount > _balance) throw new BalanceException();
    _balance -= amount;
  }

  /** 由于新旧两函数都存在，所以每次修改后我都可以编译、测试。所有调用者都被我修改完毕后，旧函数便可移除，并使用Rename Method 修改新函数名称，使它与旧函数相同。 */

  // 4、然后，调整现有的withdraw() 函数，让它调用newWithdraw() ：
  int withdraw(int amount) {
    try {
      newWithdraw(amount);
      return 0;
    } catch (BalanceException e) {
      return -1;
    }
  }

  int _balance;
}
