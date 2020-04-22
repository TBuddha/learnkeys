package com.zhout.c8重新组织数据.p1自封装值域;

/**
 * @author zhout
 * @date 2020/4/20 10:09
 */
public class Demo {

  //  private int _low, _high;
  //
  //  boolean includes(int arg) {
  //    return arg >= _low && arg <= _high;
  //  }

  // =>>>
  private int _low, _high;

  boolean includes (int arg) {
    return arg >= getLow() && arg <= getHigh();
  }
  int getLow() {return _low;}
  int getHigh() {return _high;}
}
