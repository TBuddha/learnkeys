package org.example.c10简化函数调用.p10移除设置函数;

/**
 * 问题可能以数种不同的形式出现。首先，你可能会在设值函数中对引数做运算：
 *
 * @author zhout
 * @date 2020/5/6 16:21
 */
class Account1 {
  //  private String _id;
  //
  //  Account1(String id) {
  //    setId(id);
  //  }
  //
  //  void setId(String arg) {
  //    _id = "ZZ" + arg;
  //  }

  /**
   * 如果对引数的修改很简单（就像上面这样）而且又只有一个构造函数，我可以直接在构造函数中做相同的修改。
   * 如果修改很复杂，或者有一个以上的函数调用它，我就需要提供一个独立函数。我需要为新函数起个好名字，清楚表达该函数的用途：
   */
  private String _id;

  Account1(String id) {
    initializeId(id);
  }

  void initializeId(String arg) {
    _id = "ZZ" + arg;
  }
}
