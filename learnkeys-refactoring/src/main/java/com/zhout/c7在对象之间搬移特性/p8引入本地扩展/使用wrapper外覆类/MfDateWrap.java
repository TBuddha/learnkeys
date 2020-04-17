package com.zhout.c7在对象之间搬移特性.p8引入本地扩展.使用wrapper外覆类;

import java.util.Date;

/**
 * @author zhout
 * @date 2020/4/17 10:50
 */
public class MfDateWrap {

  private Date _original;

  /** 使用wrapping方案时，我对构造函数的设定与先前有所不同。现在的构造函数将只是执行一个单纯的委托动作（delegation） */
  public MfDateWrap(String dateString) {
    _original = new Date(dateString);
  }

  /** 而转型构造函数则只是对其instance变量赋值而己： */
  public MfDateWrap(Date arg) {
    _original = arg;
  }

  /** 接下来是一项枯燥乏味的工作：为原始类的所有函数提供委托函数。我只展示几个函数，其他函数的处理依此类推 */
  public int getYear() {
    return _original.getYear();
  }

  @Override
  public boolean equals(Object arg) {
    if (this == arg) {
      return true;
    }
    if (!(arg instanceof MfDateWrap)) {
      return false;
    }
    MfDateWrap other = ((MfDateWrap) arg);
    return (_original.equals(other._original));
  }

  public int getMonth(){
    return _original.getMonth();
  }

  public int getDate(){
    return _original.getDate();
  }

  /**
   * 完成这项工作之后，我就可以后使用Move Method 将日期相关行为搬移到新class中。于是以下代码：
   * client class...
   *  private static Date nextDay(Date arg) {
   *    // foreign method, should be on date
   *    return new Date (arg.getYear(), arg.getMonth(), arg.getDate() + 1);
   * }
   *
   * 经过搬移之后，就变成
   * class MfDate...
   *  Date nextDay() {
   *    return new Date (getYear(), getMonth(), getDate() + 1);
   *  }
   */
  Date nextDay() {
    return new Date (getYear(), getMonth(), getDate() + 1);
  }
}
