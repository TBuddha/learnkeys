package com.zhout.c10简化函数调用.p9引入参数对象.after;

import java.util.Date;

/**
 * 我已经记不清有多少次看见代码以「一对值」表示「一个范围」，例如表示日期范围的start 和end、表示数值范围的upper 和lower
 * 等等。我知道为什么会发生这种情况，毕竟我自己也经常这样做。不过，自从我得知Range
 * 模式[Fowler，AP]之后，我就尽量以「范围对象」取而代之。我的第一个步骤是声明一个简单的数据容器，用以表示范围：
 *
 * @author zhout
 * @date 2020/5/6 15:49
 */
class DateRange {

  /**
   * 我把DateRange class 设为不可变，也就是说，其中所有值域都是final ，只能由构造函数来赋值，因此没有任何函数可以修改其中任何值域值。
   * 这是一个明智的决定，因为这样可以避免别名（aliasing）带来的困扰。Java 的函数参数都是pass by value（传值）， 不可变类（immutable
   * class）正是能够模仿Java 参数的工作方式，因此这种作法对于本项重构是最合适的。
   */
  DateRange(Date start, Date end) {
    _start = start;
    _end = end;
  }

  Date getStart() {
    return _start;
  }

  Date getEnd() {
    return _end;
  }

  boolean includes(Date arg) {
    return (arg.equals(_start) || arg.equals(_end) || (arg.after(_start) && arg.before(_end)));
  }

  private final Date _start;
  private final Date _end;
}
