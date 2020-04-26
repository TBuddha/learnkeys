package com.zhout.c7在对象之间搬移特性.p4将类内联化.after;

/**
 * @author zhout
 * @date 2020/4/15 14:14
 */
class Person {

  private TelephoneNumber _officeTelephone = new TelephoneNumber();

  String getAreaCode() {
    return _officeTelephone.getAreaCode(); // 译注：请注意其变化
  }

  void setAreaCode(String arg) {
    _officeTelephone.setAreaCode(arg); // 译注：请注意其变化
  }

  String getNumber() {
    return _officeTelephone.getNumber(); // 译注：请注意其变化
  }

  void setNumber(String arg) {
    _officeTelephone.setNumber(arg); // 译注：请注意其变化
  }
}
