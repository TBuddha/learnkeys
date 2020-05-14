package com.zhout.c7在对象之间搬移特性.p5隐藏委托关系;

/**
 * @author zhout
 * @date 2020/4/16 15:51
 */
class Person {

  Department _department;

  public Department getDepartment() {
    return _department;
  }

  public void setDepartment(Department arg) {
    _department = arg;
  }

  public Person getManager() {
    return _department.getManager();
  }
}
