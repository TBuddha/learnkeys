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

class HeatingPlan {

  //  boolean withinRange(int low, int high) {
  //    return (low >= _range.getLow() && high <= _range.getHigh());
  //  }

  /**
   * 其实我不必将TempRange 对象的信息拆开来单独传递，只需将整个对象传递给withinPlan()
   * 函数即可。在这个简单的例子中，我可以一次性完成修改。如果相关的参数更多些，我也可以进行小步重构。 首先，我为参数列添加新的参数项，用 以传递完整的TempRange 对象：
   */
  //  boolean withinRange2(TempRange roomRange, int low, int high) {
  //    return (low >= _range.getLow() && high <= _range.getHigh());
  //  }

  /** 以TempRange 对象提供的函数来替换low、high 参数 */
  //  boolean withinRange3(TempRange roomRange) {
  //    return (roomRange.getLow() >= _range.getLow() && roomRange.getHigh() <= _range.getHigh());
  //  }

  /** 使用完整对象后不久，你就会发现，可以将某些函数移到TempRange 对象中，使它更容易被使用，例如： */
  boolean withinRange4(TempRange roomRange) {
    return (_range.includes(roomRange));
  }

  private TempRange _range;
}

class TempRange {

  int getLow() {
    return 0;
  }

  int getHigh() {
    return 30;
  }

  boolean includes(TempRange arg) {
    return arg.getLow() >= this.getLow() && arg.getHigh() <= this.getHigh();
  }
}
