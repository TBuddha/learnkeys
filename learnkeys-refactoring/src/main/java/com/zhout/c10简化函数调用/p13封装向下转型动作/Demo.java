package com.zhout.c10简化函数调用.p13封装向下转型动作;

/**
 * @author zhout
 * @date 2020/5/7 10:07
 */
class Demo {

  /** 某个函数返回的对象，需要由函数调用者执行「向下转型」（downcast）动作。 将向下转型（downcast）动作移到函数中 */
  //  Object lastReading() {
  //    return readings.lastElement();
  //  }
  //  =>
  //  Reading lastReading() {
  //    return (Reading) readings.lastElement();
  //  }
}
