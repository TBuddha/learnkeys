package com.zhout.c7在对象之间搬移特性.p6移除中间人;

/**
 * @author zhout
 * @date 2020/4/16 16:18
 */
public class Department {
  private Person _manager;

  public Department(Person manager) {
    _manager = manager;
  }


//  public Person getManager() {
//    return _manager;
//  }
}
