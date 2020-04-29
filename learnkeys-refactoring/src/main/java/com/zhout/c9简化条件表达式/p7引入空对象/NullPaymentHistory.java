package com.zhout.c9简化条件表达式.p7引入空对象;

/**
 * @author zhout
 * @date 2020/4/28 16:16
 */
class NullPaymentHistory extends PaymentHistory {
  int getWeeksDelinquentInLastYear() {
    return 0;
  }
}
