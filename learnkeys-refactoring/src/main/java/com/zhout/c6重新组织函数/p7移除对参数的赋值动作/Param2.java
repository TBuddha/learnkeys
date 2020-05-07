package com.zhout.c6重新组织函数.p7移除对参数的赋值动作;

import java.util.Date;

/**
 * @author zhout
 * @date 2020/4/14 15:12
 */
class Param2 {

  public static void main(String[] args) {
    Date d1 = new Date("1 Apr 98");
    nextDateUpdate(d1);
    System.out.println("d1 after nextDay: " + d1);

    Date d2 = new Date("1 Apr 98");
    nextDateReplace(d2);
    System.out.println("d2 after nextDay: " + d2);
  }

  private static void nextDateUpdate(Date arg) {
    arg.setDate(arg.getDate() + 1);
    System.out.println("arg in nextDay: " + arg);
  }

  private static void nextDateReplace(Date arg) {
    arg = new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
    System.out.println("arg in nextDay: " + arg);
  }
}
