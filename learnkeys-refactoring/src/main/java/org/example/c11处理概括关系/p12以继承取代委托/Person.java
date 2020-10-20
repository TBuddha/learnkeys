package org.example.c11处理概括关系.p12以继承取代委托;

/**
 * @author zhout
 * @date 2020/5/12 15:00
 */
class Person {

  String _name;

  public String getName() {
    return _name;
  }

  public void setName(String arg) {
    _name = arg;
  }

  public String getLastName() {
    return _name.substring(_name.lastIndexOf(' ') + 1);
  }
}
