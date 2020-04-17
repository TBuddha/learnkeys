package com.zhout.c7在对象之间搬移特性.p4将类内联化.after;

/**
 * @author zhout
 * @date 2020/4/15 14:14
 */
public class TelephoneNumber {

  private String _number;
  private String _areaCode;

  public String getTelephoneNumber() {
    return ("(" + _areaCode + ") " + _number);
  }

  String getAreaCode() {
    return _areaCode;
  }

  void setAreaCode(String arg) {
    _areaCode = arg;
  }

  String getNumber() {
    return _number;
  }

  void setNumber(String arg) {
    _number = arg;
  }
}
