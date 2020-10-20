package org.example.c9简化条件表达式.p1分解条件式;

import java.util.Date;

/**
 * Decompose Conditional（分解条件式）
 *
 * @author zhout
 * @date 2020/4/26 15:00
 */
class Demo {
  Date date;
  Date SUMMER_START;
  Date SUMMER_END;

  double charge; // 费用
  Integer quantity; // 数量
  double _winterRate; // 冬季率
  double _winterServiceCharge; // 冬季服务费
  double _summerRate; // 夏季率

  public void test() {
    if (date.before(SUMMER_START) || date.after(SUMMER_END))
      charge = quantity * _winterRate + _winterServiceCharge;
    else charge = quantity * _summerRate;
  }

  // =>从if、then、else 三个段落中分别提炼出独立函数
  public void test1() {
    if (notSummer(date)) charge = winterCharge(quantity);
    else charge = summerCharge(quantity);
  }

  private boolean notSummer(Date date) {
    return date.before(SUMMER_START) || date.after(SUMMER_END);
  }

  private double summerCharge(int quantity) {
    return quantity * _summerRate;
  }

  private double winterCharge(int quantity) {
    return quantity * _winterRate + _winterServiceCharge;
  }
}
