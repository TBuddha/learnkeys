package org.example.c9简化条件表达式.p7引入空对象;

/**
 * 本系统又以PaymentHistory 表示顾客的付款记录，它也有它自己的特性
 * @author zhout
 * @date 2020/4/28 15:31
 */
class PaymentHistory {
  // 去年拖欠周数
  int getWeeksDelinquentInLastYear() {
    return 0;
  }

  static PaymentHistory newNull() {
    return new NullPaymentHistory();
  }
}
