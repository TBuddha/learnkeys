package org.example.c9简化条件表达式.p6以多态取代条件式.after;

/**
 * @author zhout
 * @date 2020/4/27 10:55
 */
class Employee {

  private EmployeeType _type;

  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  //  int payAmount() {
  //    switch (getType()) {
  //      case EmployeeType.ENGINEER:
  //        return _monthlySalary;
  //      case EmployeeType.SALESMAN:
  //        return _monthlySalary + _commission;
  //      case EmployeeType.MANAGER:
  //        return _monthlySalary + _bonus;
  //      default:
  //        throw new RuntimeException("Incorrect Employee");
  //    }
  //  }
  // =>修改Employee 中的payAmount() 函数，令它委托（delegate，转调用）EmployeeType
  int payAmount() {
    return _type.payAmount(this);
  }

  int getMonthlySalary() {
    return 0;
  }

  int getCommission() {
    return 0;
  }

  int getBonus() {
    return 0;
  }
}

abstract class EmployeeType {

  abstract int getTypeCode();

  //  int payAmount(Employee emp) {
  //    switch (getTypeCode()) {
  //      case ENGINEER:
  //        // return emp.getMonthlySalary();
  //        // 我是个徧执狂，有时我会故意在case 子句中放一个陷阱，检查Engineer class 是否正常工作（是否被调用）：
  //        throw new RuntimeException("Should be being overridden");
  //      case SALESMAN:
  //        return emp.getMonthlySalary() + emp.getCommission();
  //      case MANAGER:
  //        return emp.getMonthlySalary() + emp.getBonus();
  //      default:
  //        throw new RuntimeException("Incorrect Employee");
  //    }
  //  }
  // =>将superclass 的payAmount() 函数声明为抽象函数：
  abstract int payAmount(Employee emp);
}

class Engineer extends EmployeeType {
  int getTypeCode() {
    return Employee.ENGINEER;
  }

  // 现在，我可以处理switch 语句了。这个过程有点像淘气小男孩折磨一只昆虫——每次掰掉它一条腿。
  // 首先我把switch 语句中的"Engineer"这一分支拷贝到Engineer class：
  int payAmount(Employee emp) {
    return emp.getMonthlySalary();
  }
}

class Salesman extends EmployeeType {
  int getTypeCode() {
    return Employee.SALESMAN;
  }
  // 我重复上述过程，直到所有分支都被去除为止：
  int payAmount(Employee emp) {
    return emp.getMonthlySalary() + emp.getCommission();
  }
}

class Manager extends EmployeeType {
  int getTypeCode() {
    return Employee.MANAGER;
  }

  int payAmount(Employee emp) {
    return emp.getMonthlySalary() + emp.getBonus();
  }
}
