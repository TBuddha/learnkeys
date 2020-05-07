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
  // =>这段代码可以替换如下
  void raise(double factor) { // 提升
    salary *= (1 + factor);
  }
}

/** 当然，这个例子实在太简单了，所有人都能做到。 下面是一个稍微复杂的例子 */
class Demo {

  int lastUsage() {
    return 0;
  }

  protected Dollars baseCharge() {
    double result = Math.min(lastUsage(), 100) * 0.03;
    if (lastUsage() > 100) {
      result += (Math.min(lastUsage(), 200) - 100) * 0.05;
    }
    if (lastUsage() > 200) {
      result += (lastUsage() - 200) * 0.07;
    }
    return new Dollars(result);
  }
  //上述代码可以替换如下：
  protected Dollars baseCharge2() {

    double result = usageInRange(0, 100) * 0.03;

    result += usageInRange (100,200) * 0.05;

    result += usageInRange (200, Integer.MAX_VALUE) * 0.07;

    return new Dollars (result);

  }

  protected int usageInRange(int start, int end) {
    if (lastUsage() > start) return Math.min(lastUsage(),end) - start;
    else return 0;
  }
}

class Dollars {
  public Dollars(double arg) {}
}
