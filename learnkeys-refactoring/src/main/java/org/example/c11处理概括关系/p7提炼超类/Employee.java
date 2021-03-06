package org.example.c11处理概括关系.p7提炼超类;

/**
 * @author zhout
 * @date 2020/5/11 17:03
 */
class Employee {

  public Employee(String name, String id, int annualCost) {
    _name = name;
    _id = id;
    _annualCost = annualCost;
  }

  public int getAnnualCost() {
    return _annualCost;
  }

  public String getId() {
    return _id;
  }

  public String getName() {
    return _name;
  }

  private String _name;
  private int _annualCost; //年度成本
  private String _id;
}
