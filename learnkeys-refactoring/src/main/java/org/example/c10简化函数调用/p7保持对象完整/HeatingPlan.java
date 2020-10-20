package org.example.c10简化函数调用.p7保持对象完整;

/**
 * @author zhout
 * @date 2020/5/7 15:41
 */
class HeatingPlan {
  //  boolean withinRange(int low, int high) {
  //    return (low >= _range.getLow() && high <= _range.getHigh());
  //  }

  /**
   * 其实我不必将TempRange 对象的信息拆开来单独传递，只需将整个对象传递给withinPlan()
   * 函数即可。在这个简单的例子中，我可以一次性完成修改。如果相关的参数更多些，我也可以进行小步重构。
   * 首先，我为参数列添加新的参数项，用 以传递完整的TempRange 对象：
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
