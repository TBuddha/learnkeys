package com.zhout.c10简化函数调用.p5令函数携带参数;

/**
 * @author zhout
 * @date 2020/4/29 17:11
 */
class Employee {

  double salary;

  void tenPercentRaise() { // 提升百分之十
    salary *= 1.1;
  }

  void fivePercentRaise() { // 提升百分之五
    salary *= 1.05;
  }

  // =>上述代码可以替换如下
  void raise(double factor) { // 提升
    salary *= (1 + factor);
  }
  /** 当然，这个例子实在太简单了，所有人都能做到。 Demo是一个稍微复杂的例子 */
}
