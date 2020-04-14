package com.zhout.c6重新组织函数.p1提炼函数;

/**
 * @author zhout
 * @date 2020/4/14 11:09
 */
public class Demo {
  private String _name;

  void printOwing1(double amount) {
    printBanner();
    // print details
    System.out.println("name:" + _name);
    System.out.println("amount" + amount);
  }

  //final
  void printOwing2(double amount) {
    printBanner();
    printDetails(amount);
  }
  void printDetails (double amount) {
    System.out.println ("name:" + _name);
    System.out.println ("amount" + amount);
  }

  void printBanner() {}
}
