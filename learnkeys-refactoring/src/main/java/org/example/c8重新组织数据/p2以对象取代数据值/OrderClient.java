package org.example.c8重新组织数据.p2以对象取代数据值;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author zhout
 * @date 2020/4/20 10:38
 */
class OrderClient {

  private static int numberOfOrdersFor(Collection orders, String customer) {
    int result = 0;
    Iterator iter = orders.iterator();
    while (iter.hasNext()) {
      Order each = (Order) iter.next();
      // if (each.getCustomer().equals(customer)) result++;
      if (each.getCustomerName().equals(customer)) result++;
    }
    return result;
  }
}
