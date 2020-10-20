package org.example.c8重新组织数据.p1自封装值域;

/**
 * @author zhout
 * @date 2020/4/20 10:23
 */
class IntRange {
  private int _low, _high;

  // 1
  //  boolean includes(int arg) {
  //    return arg >= _low && arg <= _high;
  //  }
  //
  //  void grow(int factor) {
  //    _high = _high * factor;
  //  }
  //
  //  IntRange(int low, int high) {
  //    _low = low;
  //    _high = high;
  //  }

  // 2、定义「取值/设值函数」
  boolean includes(int arg) {
    return arg >= getLow() && arg <= getHigh();
  }

  void grow(int factor) {
    setHigh(getHigh() * factor);
  }

  int getLow() {
    return _low;
  }

  int getHigh() {
    return _high;
  }

  void setLow(int arg) {
    _low = arg;
  }

  void setHigh(int arg) {
    _high = arg;
  }

  /**
   * 使用本项重构时，你必须小心对待「在构造函数中使用设值函数」的情况。
   * 一般说来，设值函数被认为应该在「对象创建后」才使用，所以初始化过程中的行为有可能与设值函数的行为不同。
   * 在这种情况下，我也许在构造函数中直接访问值域，要不就是建立另一个独立的初始化函数：
   */
  IntRange(int low, int high) {
    initialize(low, high);
  }

  private void initialize(int low, int high) {
    _low = low;
    _high = high;
  }

  /** ********************************************* */
}
