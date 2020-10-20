package org.example.c10简化函数调用.p9引入参数对象;

import java.util.Date;

/**
 * 下面是一个「帐目和帐项」（account and entries）范例。表示「帐项」的Entry 实际上只是个简单的数据容器：
 *
 * @author zhout
 * @date 2020/5/6 15:17
 */
class Entry {

  Entry(double value, Date chargeDate) {
    _value = value;
    _chargeDate = chargeDate;
  }

  Date getDate() {
    return _chargeDate;
  }

  double getValue() {
    return _value;
  }

  private Date _chargeDate;

  private double _value;
}
