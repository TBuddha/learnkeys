package org.example.c10简化函数调用.p6以明确函数取代参数;

/**
 * @author zhout
 * @date 2020/4/30 10:15
 */
class Demo {

  int _height;
  int _width;

  // 你有一个函数，其内完全取决于参数值而采取不同反应。
  void setValue(String name, int value) {
    if (name.equals("height")) _height = value;
    if (name.equals("width")) _width = value;
    // Assert.shouldNeverReachHere();
  }

  // => 针对该参数的每一个可能值，建立一个独立函数。

  void setHeight(int arg) {
    _height = arg;
  }

  void setWidth(int arg) {
    _width = arg;
  }
}
