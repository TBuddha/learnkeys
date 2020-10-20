package org.example.c10简化函数调用.p13封装向下转型动作;

import java.util.Vector;

/**
 * 下面的例子中，我以Reading 表示「书籍」。我还拥有一个名为lastReading() 的函数，它从一个用以「保存Reading 对象」的Vector 中返回其最后一个元素：
 *
 * @author zhout
 * @date 2020/5/7 10:12
 */
class Client {

  //  Object lastReading() {
  //    return readings.lastElement();
  //  }
  // 我应该将这个函数变成：
  Reading lastReading() {
    return (Reading) readings.lastElement();
  }

  private Vector readings = new Vector();
}
