package com.zhout.c7在对象之间搬移特性.p3提炼类.after;

/**
 * @author zhout
 * @date 2020/4/15 13:55
 */
public class Person {

  private String _name;
  private String _officeAreaCode;
  private String _officeNumber;

  private TelephoneNumber _officeTelephone = new TelephoneNumber();

  public String getName() {
    return _name;
  }

  public String getTelephoneNumber() {
    return _officeTelephone.getTelephoneNumber();
  }

  String getOfficeAreaCode() {
    return _officeTelephone.getAreaCode();
  }

  void setOfficeAreaCode(String arg) {
    _officeTelephone.setAreaCode(arg);
  }

  String getOfficeNumber() {
    return _officeNumber;
  }

  void setOfficeNumber(String arg) {
    _officeNumber = arg;
  }

  TelephoneNumber getOfficeTelephone() {
    return _officeTelephone;
  }
}
