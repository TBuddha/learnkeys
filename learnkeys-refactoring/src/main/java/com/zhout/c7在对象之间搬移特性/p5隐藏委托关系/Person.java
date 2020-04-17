package com.zhout.c7在对象之间搬移特性.p5隐藏委托关系;

/**
 * @author zhout
 * @date 2020/4/16 15:51
 */
public class Person {

  Department _department;

  public Department getDepartment() {
    return _department;
  }

  public void setDepartment(Department arg) {
    _department = arg;
  }

  /**
   * 如果客户希望知道某人的经理是谁，他必须先取得Department对象： manager = john.getDepartment().getManager();
   * 这样的编码就是对客户揭露了Department的工作原理，于是客户知道：Department用以追踪「经理」这条信息。如果对客户隐藏Department，可以减少耦合（coupling）
   * 为了这一目的，我在Person中建立一个简单的委托函数
   */
  public Person getManager() {
    return _department.getManager();
  }
}
