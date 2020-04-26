package com.zhout.c8重新组织数据.p14以state和strategy取代型别码.after;

/**
 * 声明一个state class 。我把它声明为一个抽象类（abstract class）， 并提供一个抽象函数（abstract method）。用以返回type code
 * @author zhout
 * @date 2020/4/24 18:26
 */
abstract class EmployeeType {

  abstract int getTypeCode();

  /**
   * 首先我把type code 的定义拷贝到EmployeeType class 去，在其中建立一个factory method 以生成适当的 EmployeeType
   * 对象，并调整Employee class 中为type code 赋值的函数：
   * void setType(int arg) {
   *  _type = EmployeeType.newType(arg);
   * }
   */
  static EmployeeType newType(int code) {
    switch (code) {
      case ENGINEER:
        return new Engineer();
      case SALESMAN:
        return new Salesman();
      case MANAGER:
        return new Manager();
      default:
        throw new IllegalArgumentException("Incorrect Employee Code");
    }
  }

  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;
}

// subclass
class Engineer extends EmployeeType {
  int getTypeCode() {
    // return Employee.ENGINEER;
    return ENGINEER;
  }
}

class Salesman extends EmployeeType {
  int getTypeCode() {
    // return Employee.SALESMAN;
    return SALESMAN;
  }
}

class Manager extends EmployeeType {
  int getTypeCode() {
    // return Employee.MANAGER;
    return MANAGER;
  }
}
