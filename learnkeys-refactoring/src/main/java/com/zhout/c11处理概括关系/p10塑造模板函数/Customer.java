package com.zhout.c11处理概括关系.p10塑造模板函数;

import lombok.Getter;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 现在我将完成第一章遗留的那个范例。在此范例中，我有一个Customer ， 其中有两个用于打印的函数。
 *
 * @author zhout
 * @date 2020/5/12 11:03
 */
class Customer {

  // statement() 函数以ASCII 码打印报表（statement）：
  public String statement() {
    //    Enumeration rentals = _rentals.elements();
    //    String result = "Rental Record for " + getName() + "\n";
    //    while (rentals.hasMoreElements()) {
    //      Rental each = (Rental) rentals.nextElement();
    //      //show figures for this rental
    //      result += "\t" + each.getMovie().getTitle()+ "\t" +
    //              String.valueOf(each.getCharge()) + "\n";
    //    }
    //    //add footer lines
    //    result +=  "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    //    result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
    //            " frequent renter points";
    //    return result;
    return new TextStatement().value(this);
  }

  // 函数htmlStatement() 则以HTML 格式输出报表：
  public String htmlStatement() {
    //    Enumeration rentals = _rentals.elements();
    //    String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
    //    while (rentals.hasMoreElements()) {
    //      Rental each = (Rental) rentals.nextElement();
    //      // show figures for each rental
    //      result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) +
    // "<BR>\n";
    //    }
    //    // add footer lines
    //    result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
    //    result +=
    //        "On this rental you earned <EM>"
    //            + String.valueOf(getTotalFrequentRenterPoints())
    //            + "</EM> frequent renter points<P>";
    //    return result;
    return new HtmlStatement().value(this);
  }

  private Vector _rentals = new Vector(); // 租借记录

  private String _name; // 姓名

  public String getName() {
    return _name;
  }

  // 如果你想试着编译这段代码，还必须在Customer class 中添加一个getRentals() 函数，
  // 并放宽getTotalCharge()函数和getTotalFrequentRenterPoints() 函数的可视性（visibility ）
  public Enumeration getRentals() {
    return _rentals.elements();
  }

  // private double getTotalCharge() {
  double getTotalCharge() {
    double result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

  // private int getTotalFrequentRenterPoints() {
  int getTotalFrequentRenterPoints() {
    int result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }
}
