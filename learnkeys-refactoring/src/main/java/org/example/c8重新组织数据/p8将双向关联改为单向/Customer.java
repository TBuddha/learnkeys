package org.example.c8重新组织数据.p8将双向关联改为单向;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhout
 * @date 2020/4/22 14:33
 */
class Customer {

  // Customer-to-Order link
  private Set _orders = new HashSet();

  Set friendOrders() {
    /** should only be used by Order */
    return _orders;
  }

  void addOrder(Order arg) {
    arg.setCustomer(this);
  }

  //  double getPriceFor(Order order) {
  //    Assert.assertTrue(_orders.contains(order));
  //    return order.getDiscountedPrice();
  //  }
  // ==>
  //  double getPriceFor(Order order) {
  //    Assert.assertTrue(_orders.contains(order));
  //    return order.getDiscountedPrice(this);
  //  }
}
