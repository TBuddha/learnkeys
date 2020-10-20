package org.example.c11处理概括关系.p6提炼子类;

/**
 * 下面是JobItem class，用来决定当地修车厂的工作报价：
 *
 * @author zhout
 * @date 2020/5/11 15:01
 */
class JobItem {

  public JobItem(int unitPrice, int quantity, boolean isLabor, Employee employee) {
    _unitPrice = unitPrice;
    _quantity = quantity;
    _isLabor = isLabor;
    _employee = employee;
  }

  public int getTotalPrice() {
    return getUnitPrice() * _quantity;
  }

  public int getUnitPrice() {
    return (_isLabor) ? _employee.getRate() : _unitPrice;
  }

  public int getQuantity() {
    return _quantity;
  }

  public Employee getEmployee() {
    return _employee;
  }

  private int _unitPrice; // 单价
  private int _quantity; // 数量
  private Employee _employee; // 雇员
  private boolean _isLabor; // 是否劳工
}
