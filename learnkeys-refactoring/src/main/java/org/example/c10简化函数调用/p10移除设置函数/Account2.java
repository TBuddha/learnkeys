package org.example.c10简化函数调用.p10移除设置函数;

/**
 * @author zhout
 * @date 2020/5/6 16:24
 */
class Account2 {
  private String _id;

  Account2(String id) {
    initializeId(id);
  }

  void initializeId(String arg) {
    _id = "ZZ" + arg;
  }
}

// 如果subclass 需要对superclass 的private 变量赋初值，情况就比较麻烦一些：
class InterestAccount extends Account2 {

  private double _interestRate;

  // 编译错误
  //  InterestAccount (String id, double rate) {
  //    setId(id);
  //    _interestRate = rate;
  //  }

  // 问题是我无法在InterestAccount() 中直接访问id 变量。最好的解决方法是使用superclass 构造函数
  InterestAccount(String id, double rate) {
    super(id);
    _interestRate = rate;
  }
}
