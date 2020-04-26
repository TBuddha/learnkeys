package com.zhout.c8重新组织数据.p13以子类取代型别码;

/**
 * @author zhout
 * @date 2020/4/24 17:22
 */
public class Employee {

  private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  // 由于Employee 构造函数接受type code 作为一个参数，所以我必须将它替换为一个factory method：
  //  Employee(int type) {
  //    _type = type;
  //  }
  private Employee(int type) {
    _type = type;
  }

  //  static Employee create(int type) {
  //    return new Employee(type);
  //  }
  /** 1、修改factory method ，令它返回一个合适的对象
   *  2、继续逐一地处理其他type code ，直到所有type code 都被替换成subclass 为止
   *  3、结果见AbstractEmployee*/
  //  static Employee create(int type) {
  //    if (type == ENGINEER) return new Engineer();
  //    else return new Employee(type);
  //  }

  // 第一步是以Self-encapsulate Field 将type code 自我封装起来：
  int getType() {
    return _type;
  }
}

//class Engineer extends Employee {
//  int getType() {
//    return Employee.ENGINEER;
//  }
//}
