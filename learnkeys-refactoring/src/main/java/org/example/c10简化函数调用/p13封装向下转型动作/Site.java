package org.example.c10简化函数调用.p13封装向下转型动作;

import java.util.Vector;

/**
 * @author zhout
 * @date 2020/5/7 15:55
 */
class Site {
  Vector readings() {
    return new Vector();
  }

  Reading lastReading() {
    return (Reading) readings().lastElement();
  }
}
