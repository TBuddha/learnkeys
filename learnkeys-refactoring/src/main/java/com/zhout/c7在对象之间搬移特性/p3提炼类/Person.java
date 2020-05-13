package com.zhout.c7在对象之间搬移特性.p3提炼类;

/**
 * 某个class做了应该由两个classes做的事。
 * 建立一个新class，将相关的值域和函数从旧class搬移到新class。
 *
 * @author zhout
 * @date 2020/4/15 14:02
 */
class Person {

  private String _name;
  private String _officeAreaCode;
  private String _officeNumber;

  public String getName() {
    return _name;
  }

  public String getTelephoneNumber() {
    return ("(" + _officeAreaCode + ") " + _officeNumber);
  }

  String getOfficeAreaCode() {
    return _officeAreaCode;
  }

  void setOfficeAreaCode(String arg) {
    _officeAreaCode = arg;
  }

  String getOfficeNumber() {
    return _officeNumber;
  }

  void setOfficeNumber(String arg) {
    _officeNumber = arg;
  }
}
