package com.zhout.c7在对象之间搬移特性.p3提炼类.after;

/**
 * @author zhout
 * @date 2020/4/15 13:56
 */
class TelephoneNumber {

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
