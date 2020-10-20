package org.example.c7在对象之间搬移特性.p7引入外加函数;

import java.util.Date;

/**
 * 你所使用的server class需要一个额外函数，但你无法修改这个class。
 * 在client class中建立一个函数，并以一个server class实体作为第一引数（argument）：
 *
 * @author zhout
 * @date 2020/4/16 16:28
 */
class Demo {

  //程序中，我需要跨过一个收费周期（billing period）。原本代码像这样：
  public void test(Date previousEnd) {
    Date newStart =
        new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
  }

  //我可以将赋值运算右侧代码提炼到一个独立函数中。这个函数就是Date class的一个外加函数：
  public void test1(Date previousEnd) {
    Date newStart = nextDay(previousEnd);
  }

  private static Date nextDay(Date arg) {
    return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
  }
}
