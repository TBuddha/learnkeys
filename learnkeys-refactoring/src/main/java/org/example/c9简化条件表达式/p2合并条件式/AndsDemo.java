package org.example.c9简化条件表达式.p2合并条件式;

/**
 * @author zhout
 * @date 2020/4/26 17:25
 */
class AndsDemo {

  public boolean onVacation() {
    return false;
  }

  public Integer lengthOfService() {
    return null;
  }

  public double test() {
    if (onVacation()) if (lengthOfService() > 10) return 1;
    return 0.5;
  }
  // 这段代码可以变成
  public double test1() {
    if (onVacation() && lengthOfService() > 10) return 1;
    else return 0.5;
  }

  // 是对条件进行检查并返回一个值，我可以使用三元操作符将这一部分变成一条return 语句
  public double test2() {
    return (onVacation() && lengthOfService() > 10) ? 1 : 0.5;
  }
}
