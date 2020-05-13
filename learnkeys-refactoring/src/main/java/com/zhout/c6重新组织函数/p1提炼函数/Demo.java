package com.zhout.c6重新组织函数.p1提炼函数;

/**
 * 有一段代码可以被组织在一起并独立出来。 将这段代码放进一个独立函数中，并让函数名称解释该函数的用途。
 *
 * @author zhout
 * @date 2020/4/14 11:09
 */
class Demo {
  private String _name;

  void printOwing(double amount) {
    printBanner();
    // print details
    System.out.println("name:" + _name);
    System.out.println("amount" + amount);
  }

  // 将这段代码放进一个独立函数中，并让函数名称解释该函数的用途
  void printOwing1(double amount) {
    printBanner();
    printDetails(amount);
  }

  void printDetails(double amount) {
    System.out.println("name:" + _name);
    System.out.println("amount" + amount);
  }

  void printBanner() {}
}
