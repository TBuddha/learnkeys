package com.zhout.c8重新组织数据.p15以值域取代子类;

/**
 * @author zhout
 * @date 2020/4/26 11:20
 */
class Female extends Person {
  boolean isMale() {
    return false;
  }

  char getCode() {
    return 'F';
  }
}
