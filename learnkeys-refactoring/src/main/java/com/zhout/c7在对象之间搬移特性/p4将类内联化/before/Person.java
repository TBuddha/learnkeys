package com.zhout.c7在对象之间搬移特性.p4将类内联化.before;

import com.zhout.c7在对象之间搬移特性.p3提炼类.after.TelephoneNumber;

/**
 * @author zhout
 * @date 2020/4/15 14:09
 */
class Person {

  private String _name;
  private TelephoneNumber _officeTelephone = new TelephoneNumber();

  public String getName() {
    return _name;
  }

  public String getTelephoneNumber() {
    return _officeTelephone.getTelephoneNumber();
  }

  TelephoneNumber getOfficeTelephone() {
    return _officeTelephone;
  }
}
