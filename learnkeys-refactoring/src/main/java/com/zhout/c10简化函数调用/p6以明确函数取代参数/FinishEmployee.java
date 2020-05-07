package com.zhout.c10简化函数调用.p6以明确函数取代参数;

/**
 * @author zhout
 * @date 2020/4/30 14:28
 */
class FinishEmployee {
  static Employee createEngineer() {
    return new Engineer();
  }

  static Employee createSalesman() {
    return new Salesman();
  }

  static Employee createManager() {
    return new Manager();
  }

  public static void main(String[] args) {
    Employee kent = Employee.createEngineer();
  }
}
