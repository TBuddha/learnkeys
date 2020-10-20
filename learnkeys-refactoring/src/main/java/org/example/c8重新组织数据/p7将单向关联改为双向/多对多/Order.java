package org.example.c8重新组织数据.p7将单向关联改为双向.多对多;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhout
 * @date 2020/4/22 11:12
 */
class Order {

  private Set _customers = new HashSet();

  void addCustomer(Customer arg) {
    arg.friendOrders().add(this);
    _customers.add(arg);
  }

  void removeCustomer(Customer arg) {
    arg.friendOrders().remove(this);
    _customers.remove(arg);
  }
}

class Customer {

  private Set _orders = new HashSet();

  Set friendOrders() {
    return _orders;
  }

  void addOrder(Order arg) {
    arg.addCustomer(this);
  }

  void removeOrder(Order arg) {
    arg.removeCustomer(this);
  }
}
