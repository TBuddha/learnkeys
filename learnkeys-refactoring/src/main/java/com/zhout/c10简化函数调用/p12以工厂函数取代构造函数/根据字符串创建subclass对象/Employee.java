package com.zhout.c10简化函数调用.p12以工厂函数取代构造函数.根据字符串创建subclass对象;

/**
 * @author zhout
 * @date 2020/5/6 17:06
 */
class Employee {

  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  //  static Employee create(int type) {
  //    switch (type) {
  //      case ENGINEER:
  //        return new Engineer();
  //      case SALESMAN:
  //        return new Salesman();
  //      case MANAGER:
  //        return new Manager();
  //      default:
  //        throw new IllegalArgumentException("Incorrect type code value");
  //    }
  //  }
  // 可惜的是，这里面有一个switch 语句。如果我添加一个新的subclass ，就必须记得更新这里的switch 语句，而我又偏偏很健忘。

  // 绕过这个switch 语句的一个好办法是使用Class.forName() 。第一件要做的事是修改参数型别，这从根本上说是Rename Method 的一种变体。
  // 首先我得建立一个函数，让它接收一个字符串引数（string argument）：
  static Employee create(String name) {
    try {
      return (Employee) Class.forName(name).newInstance();
    } catch (Exception e) {
      throw new IllegalArgumentException("Unable to instantiate" + name);
    }
  }

  // client code...
  public void client() {
    // Employee eng = Employee.create(ENGINEER);
    // 修改为：
    Employee eng = Employee.create("Engineer");
    // 完成之后，我就可以将「create() 函数，int 版本」移除了。
  }
}
