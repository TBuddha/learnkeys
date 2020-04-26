package com.zhout.c8重新组织数据.p8将双向关联改为单向;

/**
 * @author zhout
 * @date 2020/4/22 14:33
 */
public class Order {

  // Order-to-Customer link，也是本例的移除对象
  private Customer _customer;

  Customer getCustomer() {
    return _customer;
  }

  void setCustomer(Customer arg) {
    if (_customer != null) _customer.friendOrders().remove(this);
    _customer = arg;
    if (_customer != null) _customer.friendOrders().add(this);
  }

  // example
  //  double getDiscountedPrice() {
  //    return getGrossPrice() * (1 - _customer.getDiscount());
  //  }
  //  ==>
  //  double getDiscountedPrice(Customer customer) {
  //    return getGrossPrice() * (1 - customer.getDiscount());
  //  }
}
