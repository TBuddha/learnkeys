package com.zhout.c8重新组织数据.p7将单向关联改为双向;

/**
 * @author zhout
 * @date 2020/4/21 11:13
 */
public class Order {

  Customer _customer;

  Customer getCustomer() {
    return _customer;
  }

  //  void setCustomer(Customer arg) {
  //    _customer = arg;
  //  }
  // ==>改变修改函数（modifier），令它同时更新反向指针：
  void setCustomer(Customer arg) {
    if (_customer != null) _customer.friendOrders().remove(this);
    _customer = arg;
    if (_customer != null) _customer.friendOrders().add(this);
  }
}
