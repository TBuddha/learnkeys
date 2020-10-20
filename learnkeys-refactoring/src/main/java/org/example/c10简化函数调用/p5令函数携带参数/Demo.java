package org.example.c10简化函数调用.p5令函数携带参数;

/**
 * @author zhout
 * @date 2020/5/7 15:24
 */
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

  protected Dollars baseCharge1() {

    double result = usageInRange(0, 100) * 0.03;

    result += this.usageInRange (100,200) * 0.05;

    result += usageInRange (200, Integer.MAX_VALUE) * 0.07;

    return new Dollars (result);

  }

  protected int usageInRange(int start, int end) {
    if (lastUsage() > start) return Math.min(lastUsage(),end) - start;
    else return 0;
  }
}
