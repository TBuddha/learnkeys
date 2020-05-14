package com.zhout.c7在对象之间搬移特性.p6移除中间人;

/**
 * @author zhout
 * @date 2020/4/16 16:18
 */
class Person {

  Department _department;

  public Department getDepartment() {
    return _department;
  }

  // 移除
  //  public Person getManager() {
  //    return _department.getManager();
  //  }
}
