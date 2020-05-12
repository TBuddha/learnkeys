package com.zhout.c11处理概括关系.p6提炼子类.after;

/**
 * 我要提炼出一个LaborItem subclass，因为上述某些行为和数据只在labor (劳工） 情况下才需要。首先建立这样一个class：
 *
 * @author zhout
 * @date 2020/5/11 15:08
 */
class LaborItem extends JobItem {

  public LaborItem(int quantity, Employee employee) {
    super(0, quantity, true);
    _employee = employee;
  }

  public Employee getEmployee() {
    return _employee;
  }

  @Override
  protected boolean isLabor() {
    return true;
  }

  @Override
  public int getUnitPrice() {
    return _employee.getRate();
  }
}
