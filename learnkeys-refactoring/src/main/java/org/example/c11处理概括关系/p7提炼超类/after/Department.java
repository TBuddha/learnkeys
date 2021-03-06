package org.example.c11处理概括关系.p7提炼超类.after;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author zhout
 * @date 2020/5/11 17:05
 */
class Department extends Party {

  public Department(String name) {
    super(name);
  }

  // public int getTotalAnnualCost() {
  public int getAnnualCost() {
    Enumeration e = getStaff();
    int result = 0;
    while (e.hasMoreElements()) {
      Employee each = (Employee) e.nextElement();
      result += each.getAnnualCost();
    }
    return result;
  }

  public int getHeadCount() { // 人数
    return _staff.size();
  }

  public Enumeration getStaff() {
    return _staff.elements();
  }

  public void addStaff(Employee arg) {
    _staff.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  private String _name;
  private Vector _staff = new Vector(); // 人员
}
