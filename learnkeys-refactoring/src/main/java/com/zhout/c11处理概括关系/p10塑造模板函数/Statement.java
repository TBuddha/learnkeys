package com.zhout.c11处理概括关系.p10塑造模板函数;

import java.util.Enumeration;

/**
 * 针对「报表输出」使用Strategy 模式
 *
 * @author zhout
 * @date 2020/5/12 11:11
 */

// 所有这些修改都完成后，两个value() 函数看上去已经非常相似了，
// 因此我可以使用Pull Up Method 将它们提升到superclass中。
// 提升完毕后，我需要在superclass中把subclass 函数声明为抽象函数。
abstract class Statement {
  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = headerString(aCustomer);
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += eachRentalString(each);
    }
    result += footerString(aCustomer);
    return result;
  }

  abstract String headerString(Customer aCustomer);

  abstract String eachRentalString(Rental aRental);

  abstract String footerString(Customer aCustomer);
}

// 通过Move Method，我将两个负责输出报表的函数分别搬移到对应的subclass中
class TextStatement extends Statement {

  @Override
  String headerString(Customer aCustomer) {
    return "Rental Record for " + aCustomer.getName() + "\n";
  }

  @Override
  String eachRentalString(Rental aRental) {
    return "\t" + aRental.getMovie().getTitle() + "\t" + String.valueOf(aRental.getCharge()) + "\n";
  }

  @Override
  String footerString(Customer aCustomer) {
    return "Amount owed is "
        + String.valueOf(aCustomer.getTotalCharge())
        + "\n"
        + "You earned "
        + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
        + " frequent renter points";
  }
}

class HtmlStatement extends Statement {

  @Override
  String headerString(Customer aCustomer) {
    return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
  }

  @Override
  String eachRentalString(Rental aRental) {
    return aRental.getMovie().getTitle() + ": " + String.valueOf(aRental.getCharge()) + "<BR>\n";
  }

  @Override
  String footerString(Customer aCustomer) {
    return "<P>You owe <EM>"
        + String.valueOf(aCustomer.getTotalCharge())
        + "</EM><P>"
        + "On this rental you earned <EM>"
        + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
        + "</EM> frequent renter points<P>";
  }
}
