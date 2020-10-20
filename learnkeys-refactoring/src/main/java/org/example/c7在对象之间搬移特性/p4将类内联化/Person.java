package org.example.c7在对象之间搬移特性.p4将类内联化;

/**
 * 先前（上个重构项〉我从TelephoneNumber「提炼出另一个class，现在我要将它inlining塞回到Person去。一开始这两个classes是分离的：
 *
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
