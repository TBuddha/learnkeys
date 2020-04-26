package com.zhout.c8重新组织数据.p14以state和strategy取代型别码.before;

/**
 * @author zhout
 * @date 2020/4/24 18:01
 */
public class Employee {
  private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  int _monthlySalary; // 月薪
  int _commission; // 佣金
  int _bonus; // 奖金

  //  Employee (int type) {
  //    _type = type;
  //  }
  // ==>使用Self Encapsulate Field 将表示type code 的值域自我封装起来
  Employee(int type) {
    setType(type);
  }

  int getType() {
    return _type;
  }

  void setType(int arg) {
    _type = arg;
  }

  int payAmount() {
    // switch (_type) {
    // ==>
    switch (getType()) {
      case ENGINEER:
        return _monthlySalary;
      case SALESMAN:
        return _monthlySalary + _commission;
      case MANAGER:
        return _monthlySalary + _bonus;
      default:
        throw new RuntimeException("Incorrect Employee");
    }
  }
}
