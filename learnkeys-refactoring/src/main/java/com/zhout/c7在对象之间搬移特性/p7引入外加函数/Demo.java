package com.zhout.c7在对象之间搬移特性.p7引入外加函数;

import java.util.Date;

/**
 * @author zhout
 * @date 2020/4/16 16:28
 */
class Demo {

  public void test(Date previousEnd) {
    Date newStart =
        new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
  }

  public void test1(Date previousEnd) {
    Date newStart = nextDay(previousEnd);
  }

  private static Date nextDay(Date arg) {
    return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
  }
}
