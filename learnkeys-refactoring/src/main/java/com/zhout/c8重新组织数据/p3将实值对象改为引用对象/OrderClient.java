package com.zhout.c8重新组织数据.p3将实值对象改为引用对象;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author zhout
 * @date 2020/4/20 15:37
 */
public class OrderClient {

  private static int numberOfOrdersFor(Collection orders, String customer) {
    int result = 0;
    Iterator iter = orders.iterator();
    while (iter.hasNext()) {
      Order each = (Order) iter.next();
      if (each.getCustomerName().equals(customer)) result++;
    }
    return result;
  }
}
