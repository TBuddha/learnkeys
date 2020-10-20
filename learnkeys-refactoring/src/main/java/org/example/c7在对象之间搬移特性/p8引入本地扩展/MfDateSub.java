package org.example.c7在对象之间搬移特性.p8引入本地扩展;

import java.util.Date;

/**
 * @author zhout
 * @date 2020/4/17 10:35
 */
class MfDateSub extends Date {

  public MfDateSub nextDay(){
    return null;
  }

  public int dayOfYear(){
    return -1;
  }
}
