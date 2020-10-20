package org.example.c10简化函数调用.p6以明确函数取代参数;

/**
 * 下列代码中，我想根据不同的参数值，建立Employee 之下不同的subclass。以下代码往往是Replace Constructor with Factory Method 的施行成果：
 *
 * @author zhout
 * @date 2020/4/30 14:18
 */
class Employee {

  static final int ENGINEER = 0;

  static final int SALESMAN = 1;

  static final int MANAGER = 2;

  // 由于这是一个factory method，我不能实施用多态替换条件，因为使用该函数时我根本尚未创建出对象。
  static Employee create(int type) {
    switch (type) {
      case ENGINEER:
        // 2、然后把「switch 语句的各个分支」替换为「对新函数的调用」
        // return new Engineer();
        return Employee.createEngineer();
      case SALESMAN:
        // return new Salesman();
        return Employee.createSalesman();
      case MANAGER:
        // return new Manager();
        return Employee.createManager();
      default:
        throw new IllegalArgumentException("Incorrect type code value");
    }
  }

  // 1、我并不期待太多新的subclasses，所以一个明确的接口是合理的（译注：不甚理解作者文意）。首先，我要根据参数值建立相应的新函数：
  static Employee createEngineer() {
    return new Engineer();
  }

  static Employee createSalesman() {
    return new Salesman();
  }

  static Employee createManager() {
    return new Manager();
  }
  // --------------------------------------//

  // 4、接下来，我把注意力转移到旧函数的调用端。我把诸如下面这样的代码：
  public static void main(String[] args) {
    // Employee kent = Employee.create(ENGINEER);
    // =>替换为：
    Employee kent = Employee.createEngineer();
    /** 修改完create() 函数的所有调用者之后，我就可以把create() 函数删掉了。同时也可以把所有常量都删掉。 见Employee2 */
  }
}
