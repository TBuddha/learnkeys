package com.zhout.c8重新组织数据.p3将实值对象改为引用对象;

/**
 * @author zhout
 * @date 2020/4/20 15:37
 */
public class Order {

  private Customer _customer;

  //  public Order(String customerName) {
  //    _customer = new Customer(customerName);
  //  }
  // ==>
  // 把「对构造函数的调用」替换成「对factory method的调用」：
  public Order(String customer) {
    //_customer = Customer.create(customer);
    _customer = Customer.getNamed(customer);
  }

  public void setCustomer(String customerName) {
    //_customer = new Customer(customerName);
    _customer = Customer.getNamed(customerName);
  }

  public String getCustomerName() {
    return _customer.getName();
  }
}
