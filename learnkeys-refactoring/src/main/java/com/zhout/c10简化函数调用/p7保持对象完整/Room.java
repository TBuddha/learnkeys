package com.zhout.c10简化函数调用.p7保持对象完整;

/**
 * 以下范例，我以一个Room 对象表示「房间」，它负责记录房间一天中的最高温度和最低温度。 然后这个对象需要将「实际温度范围」与预先规定的「温度控制计划」
 * 相比较，告诉客户当天温度是否符合计划要求：
 *
 * @author zhout
 * @date 2020/5/6 14:20
 */
class Room {

  //  boolean withinPlan(HeatingPlan plan) {
  //    int low = daysTempRange().getLow();
  //    int high = daysTempRange().getHigh();
  //    return plan.withinRange(low, high);
  //  }

  //  boolean withinPlan2(HeatingPlan plan) {
  //    int low = daysTempRange().getLow();
  //    int high = daysTempRange().getHigh();
  //    return plan.withinRange2(daysTempRange(), low, high);
  //  }

  //  boolean withinPlan3(HeatingPlan plan) {
  //    int low = daysTempRange().getLow();
  //    int high = daysTempRange().getHigh();
  //    return plan.withinRange3(daysTempRange());
  //  }

  /** 现在，我不再需要low 和high 这两个临时变量了 */
  boolean withinPlan4(HeatingPlan plan) {
    return plan.withinRange4(daysTempRange());
  }

  TempRange daysTempRange() {
    return new TempRange();
  }
}
