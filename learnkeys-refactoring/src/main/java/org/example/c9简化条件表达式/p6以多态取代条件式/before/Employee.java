package org.example.c9简化条件表达式.p6以多态取代条件式.before;

/**
 * @author zhout
 * @date 2020/4/27 10:45
 */
class Employee {

  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  int payAmount() {
    switch (getType()) {
      case EmployeeType.ENGINEER:
        return _monthlySalary;
      case EmployeeType.SALESMAN:
        return _monthlySalary + _commission;
      case EmployeeType.MANAGER:
        return _monthlySalary + _bonus;
      default:
        throw new RuntimeException("Incorrect Employee");
    }
  }

  int _monthlySalary; // 月薪
  int _commission; // 佣金
  int _bonus; // 奖金

  int getType() {
    return _type.getTypeCode();
  }

  private EmployeeType _type;
}

abstract class EmployeeType {

  abstract int getTypeCode();

  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;
}

class Engineer extends EmployeeType {
  int getTypeCode() {
    return Employee.ENGINEER;
  }
}

// ... and other subclasses
