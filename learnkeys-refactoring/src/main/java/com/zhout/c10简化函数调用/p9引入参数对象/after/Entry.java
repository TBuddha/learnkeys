package com.zhout.c10简化函数调用.p9引入参数对象.after;

import java.util.Date;

/**
 * @author zhout
 * @date 2020/5/6 15:48
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
