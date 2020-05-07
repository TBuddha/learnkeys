package com.zhout.c10简化函数调用.p15以测试取代异常;

/**
 * 面对一个「调用者可预先加以检查」的条件，你抛出了一个异常。 修改调用者，使它在调用函数之前先做检查。
 *
 * @author zhout
 * @date 2020/5/7 14:41
 */
class Demo {
  double getValueForPeriod(int periodNumber) {
    try {
      return _values[periodNumber];
    } catch (ArrayIndexOutOfBoundsException e) {
      return 0;
    }
  }

  // =>

  double getValueForPeriod1(int periodNumber) {
    if (periodNumber >= _values.length) return 0;
    return _values[periodNumber];
  }

  int[] _values;
}
