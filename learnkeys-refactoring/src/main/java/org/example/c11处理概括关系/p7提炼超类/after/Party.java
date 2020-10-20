package org.example.c11处理概括关系.p7提炼超类.after;

/**
 * @author zhout
 * @date 2020/5/11 17:37
 */
abstract class Party { // 团体

  // 把特性上移至superclass 。先实施Pull Up Field 通常会比较简单
  private String _name;

  protected Party (String name) {
    _name = name;
  }

  public String getName() {
    return _name;
  }

  abstract public int getAnnualCost();
}
