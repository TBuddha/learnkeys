package com.zhout.c6重新组织函数.p1提炼函数;

import lombok.Getter;

import java.util.Enumeration;

/**
 * @author zhout
 * @date 2020/4/14 11:11
 */
public class Demo2 {

  private Order _orders;

  private String _name;

  void printOwing() {
    Enumeration e = _orders.elements();
    double outstanding = 0.0;
    // print banner
    System.out.println("**************************");
    System.out.println("***** Customer Owes ******");
    System.out.println("**************************");
    // calculate outstanding
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      outstanding += each.getAmount();
    }
    // print details
    System.out.println("name:" + _name);
    System.out.println("amount" + outstanding);
  }

  // 范例（examples）：无局部变量（No Local Variables）
  void printOwing2() {
    Enumeration e = _orders.elements();
    double outstanding = 0.0;
    printBanner();
    // calculate outstanding
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      outstanding += each.getAmount();
    }
    // print details
    System.out.println("name:" + _name);
    System.out.println("amount" + outstanding);
  }

  void printBanner() {
    // print banner
    System.out.println("**************************");
    System.out.println("***** Customer Owes ******");
    System.out.println("**************************");
  }

  // 范例（Examples）：有局部变量（Using Local Variables）
  // 打印详细信息」这一部分提炼为「带一个参数的函数
  void printOwing3() {
    Enumeration e = _orders.elements();
    double outstanding = 0.0;
    printBanner();
    // calculate outstanding
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      outstanding += each.getAmount();
    }
    printDetails(outstanding);
  }

  void printDetails(double outstanding) {
    System.out.println("name:" + _name);
    System.out.println("amount" + outstanding);
  }

  // 范例（Examples）：对局部变量再赋值（Reassigning a Local Variable）
  void printOwing4() {
    printBanner();
    double outstanding = getOutstanding();
    printDetails(outstanding);
  }

  double getOutstanding() {
    //    Enumeration e = _orders.elements();
    //    double outstanding = 0.0;
    //    while (e.hasMoreElements()) {
    //      Order each = (Order) e.nextElement();
    //      outstanding += each.getAmount();
    //    }
    //    return outstanding;

    // 修改命名规则
    Enumeration e = _orders.elements();
    double result = 0.0;
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      result = each.getAmount();
    }
    return result;
  }
  /** ************************************************************ */

  // 如有传参
  void printOwing5(double previousAmount) {
    Enumeration e = _orders.elements();
    double outstanding = previousAmount * 1.2;
    printBanner();
    // calculate outstanding
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      outstanding += each.getAmount();
    }
    printDetails(outstanding);
  }

  void printOwing6(double previousAmount) {
    double outstanding = previousAmount * 1.2;
    printBanner();
    outstanding = getOutstanding(outstanding);
    printDetails(outstanding);
  }

  double getOutstanding(double initialValue) {
    double result = initialValue;
    Enumeration e = _orders.elements();
    while (e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      result += each.getAmount();
    }
    return result;
  }

  //final
  void printOwing7(double previousAmount) {
    printBanner();
    double outstanding = getOutstanding(previousAmount * 1.2);
    printDetails(outstanding);
  }

  public static class Order {

    @Getter double amount;

    public Enumeration<String> elements() {
      return null;
    }
  }
}
