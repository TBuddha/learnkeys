package org.example.c11处理概括关系.p2函数上移;

import java.util.Date;

/**
 * 我以Customer「表示「顾客」，它有两个subclass ：表示「普通顾客」的RegularCustomer 和表示「贵宾」PreferredCustomer。
 *
 * @author zhout
 * @date 2020/5/7 16:38
 */
abstract class Customer {

  // 但我不能直接把这个函数上移到superclass，因为各个subclass 的chargeFor() 函数并不相同。
  // 我必须先在superclass 中声明chargeFor() 抽象函数：
  abstract double chargeFor(Date start, Date end);
}

class RegularCustomer extends Customer {

  // 两个subclass 都有一个createBill() 函数，并且代码完全一样：
//  void createBill(Date date) {
//    double chargeAmount = chargeFor(lastBillDate, date);
//    addBill(date, charge);
//  }

  @Override
  double chargeFor(Date start, Date end) {
    return 0.0;
  }
}

class PreferredCustomer extends Customer {
  //  void createBill(Date date) {
  //    double chargeAmount = chargeFor(lastBillDate, date);
  //    addBill(date, charge);
  //  }

  @Override
  double chargeFor(Date start, Date end) {
    return 9.9;
  }
}
