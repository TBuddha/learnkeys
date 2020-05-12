package com.zhout.c11处理概括关系.p12以继承取代委托;

/**
 * @author zhout
 * @date 2020/5/12 15:00
 */
// 1.第一步，只需声明两者之间的继承关系：
// class Employee {
class Employee extends Person {

  Person _person = new Person();

  // 2.一步要将「受托值域」（delegated field）设值为「该值域所处之对象自身」。同时，我必须先删掉所有简单的请托函数
  // （例如getName()和setName()）。如果留下这种函数，就会因为无限递归而引起系统的call stack 满溢（overflow）。
  // 在此范例中，我应该把Employee 的getName()和setName() 拿掉。
  //  public String getName() {
  //    return _person.getName();
  //  }
  //
  //  public void setName(String arg) {
  //    _person.setName(arg);
  //  }

  // 3.一旦Employee 可以正常工作了，我就修改其中「使用了请托函数（译注：或受托值域）」的函数，让它们直接调用「从superclass 继承而来的函数」：
  public String toString() {
    // return "Emp: " + _person.getLastName();
    return "Emp: " + getLastName();
  }

  // ------ 摆脱所有涉及委托关系的函数后，我也就可以摆脱_person 这个（受托）值域了。 -----//
}
