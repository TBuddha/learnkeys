package com.zhout.c10简化函数调用.p9引入参数对象;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 我关注的焦点是用以表示「帐目」的Account，它保存了一组Entry 对象，并有一个函数用来计算两日期间的帐项总量：
 *
 * @author zhout
 * @date 2020/5/6 15:18
 */
class Account {

  double getFlowBetween(Date start, Date end) {
    double result = 0;
    Enumeration e = _entries.elements();
    while (e.hasMoreElements()) {
      Entry each = (Entry) e.nextElement();
      if (each.getDate().equals(start)
          || each.getDate().equals(end)
          || (each.getDate().after(start) && each.getDate().before(end))) {
        result += each.getValue();
      }
    }
    return result;
  }

  private Vector _entries = new Vector();
}
