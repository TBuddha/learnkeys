package org.example.c10简化函数调用.p9引入参数对象.after;

import java.util.Date;

/**
 * @author zhout
 * @date 2020/5/6 15:56
 */
class Client {
  Account anAccount;
  Date startDate;
  Date endDate;

  public void test() {
    // double flow = anAccount.getFlowBetween(startDate, endDate, null);
    // double flow = anAccount.getFlowBetween(endDate, new DateRange(startDate, null));
    double flow = anAccount.getFlowBetween(new DateRange(startDate, endDate));
  }
}
