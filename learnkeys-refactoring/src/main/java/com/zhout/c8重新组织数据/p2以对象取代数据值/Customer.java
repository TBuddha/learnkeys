package com.zhout.c8重新组织数据.p2以对象取代数据值;

/**
 * @author zhout
 * @date 2020/4/20 10:42
 */
class Customer {

  private final String _name;

  public Customer (String name) {
    _name = name;
  }
  public String getName() {
    return _name;
  }
}
