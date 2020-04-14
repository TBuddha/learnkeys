package com.zhout.c1影片出租.after;

import lombok.Getter;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author zhout
 * @date 2020/3/26 11:23
 */
public class Customer {
  @Getter private String _name; // 姓名
  private Vector _rentals = new Vector(); // 租借记录

  public Customer(String name) {
    _name = name;
  };

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  };

  public String statement() {
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      // show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }
    // add footer lines
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result +=
        "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
    return result;
  }

  // 译注：此即所谓query method
  private double getTotalCharge() {
    double result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

  // 译注：此即所谓query method
  private int getTotalFrequentRenterPoints() {
    int result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

  public String htmlStatement() {
    Enumeration rentals = _rentals.elements();
    String result = "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      // show figures for each rental
      result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
    }
    // add footer lines
    result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
    result +=
        "On this rental you earned <EM>"
            + String.valueOf(getTotalFrequentRenterPoints())
            + "</EM> frequent renter points<P>";
    return result;
  }
}
