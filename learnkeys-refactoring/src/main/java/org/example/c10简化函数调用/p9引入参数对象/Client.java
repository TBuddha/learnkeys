package org.example.c10简化函数调用.p9引入参数对象;

import java.util.Date;

/**
 * @author zhout
 * @date 2020/5/6 15:21
 */
class Client {

  Account anAccount;
  Date startDate;
  Date endDate;

  public void test() {
    double flow = anAccount.getFlowBetween(startDate, endDate);
  }
}
