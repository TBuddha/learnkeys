package org.example.c7在对象之间搬移特性.p5隐藏委托关系;

/**
 * @author zhout
 * @date 2020/4/16 15:52
 */
class Department {

  private String _chargeCode;
  private Person _manager;

  public Department(Person manager) {
    _manager = manager;
  }

  public Person getManager() {
    return _manager;
  }
}
