package com.zhout.c8重新组织数据.p14以state和strategy取代型别码.after;

/**
 * @author zhout
 * @date 2020/4/24 18:19
 */
class Employee {

  //  static final int ENGINEER = 0;
  //  static final int SALESMAN = 1;
  //  static final int MANAGER = 2;

  // 修改type code 访问函数（accessors），实实在在地把这些subclasses 和Employee class 联系起来：
  private EmployeeType _type;

  int getType() {
    return _type.getTypeCode();
  }

  //  void setType(int arg) {
  //    switch (arg){
  //      case ENGINEER:
  //        _type = new Engineer();
  //        break;
  //      case SALESMAN:
  //        _type = new Salesman();
  //      case MANAGER:
  //        _type = new Manager();
  //    }
  //  }
  // --------------------------------------------------//
  // ==>
  void setType(int arg) {
    _type = EmployeeType.newType(arg);
  }

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
}
