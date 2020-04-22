package com.zhout.c8重新组织数据.p2以对象取代数据值;

/**
 * @author zhout
 * @date 2020/4/20 10:38
 */
public class Order {

  // 1
  //  private String _customer;
  //
  //  public Order(String customer) {
  //    _customer = customer;
  //  }
  //
  //  public String getCustomer() {
  //    return _customer;
  //  }
  //
  //  public void setCustomer(String arg) {
  //    _customer = arg;
  //  }

  /**
   * 现在，我要将Order中的_customer值域的型别修改为Customer； 并修改所有引用此一值域的函数，让它们恰当地改而使用Customer实体。
   * 其中取值函数和构造函数的修改都很简单； 至于设值函数（setter），我让它创建一份Customer实体。
   */
  private Customer _customer;

  //  public String getCustomer() {
  //    return _customer.getName();
  //  }
  // ==>
  // 对于取值函数，我会使用 Rename Method 改变其名称，让它更清晰地表示，它所返回的是消费者名称，而不是个Customer对象
  public String getCustomerName() {
    return _customer.getName();
  }

  //  public Order(String customer) {
  //    _customer = new Customer(customer);
  //  }

  //  public void setCustomer(String arg) {
  //    _customer = new Customer(arg);
  //  }
  // ==>
  // 至于构造函数和设值函数，我就不必修改其签名（signature）了，但参数名称得改：
  public Order(String customerName) {
    _customer = new Customer(customerName);
  }

  public void setCustomer(String customerName) {
    _customer = new Customer(customerName);
  }

  /** *************************************** */
}
