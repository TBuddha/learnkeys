package org.example.c10简化函数调用.p7保持对象完整;

/**
 * @author zhout
 * @date 2020/5/7 15:42
 */
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
