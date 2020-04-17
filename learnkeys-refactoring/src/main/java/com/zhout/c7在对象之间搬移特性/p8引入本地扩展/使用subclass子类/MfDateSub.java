package com.zhout.c7在对象之间搬移特性.p8引入本地扩展.使用subclass子类;

import java.util.Date;

/**
 * @author zhout
 * @date 2020/4/17 10:19
 *     <p>Date的subclass
 */
public class MfDateSub extends Date {

  /** 然后，我需要处理Date和我的扩展类之间的不同处。MfDateSub 构造函数需要委托给Date构造函数： */
  public MfDateSub(String dateString) {
    super(dateString);
  }

  /** 现在，我需要加入一个转型构造函数，其参数是一个隶属源类的对象 */
  public MfDateSub(Date arg) {
    super(arg.getTime());
  }

  /**
   * 现在，我可以在extension class(扩展类)中添加新特性，并使用Move Method 将所有外加函数（foreign methods）搬移到extension
   * class。于是，下面的代码：
   * client class...
   *  private static Date nextDay(Date arg) {
   *  // foreign method,should be on date
   *    return new Date (arg.getYear(),arg.getMonth(), arg.getDate() + 1);
   *  }
   *
   * 经过搬移之后，就成了：
   *
   * class MfDateSub...
   *  Date nextDay() {
   *    return new Date (getYear(),getMonth(), getDate() + 1);
   *  }
   */
  Date nextDay() {
    return new Date (getYear(), getMonth(), getDate() + 1);
  }
}
