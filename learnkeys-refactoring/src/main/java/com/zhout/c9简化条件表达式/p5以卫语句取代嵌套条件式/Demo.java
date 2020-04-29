package com.zhout.c9简化条件表达式.p5以卫语句取代嵌套条件式;

/**
 * Replace Nested Conditional with Guard Clauses（以卫语句取代嵌套条件式)
 *
 * @author zhout
 * @date 2020/4/27 09:42
 */
class Demo {

  double getPayAmount() {
    double result;
    if (_isDead) result = deadAmount();
    else {
      if (_isSeparated) result = separatedAmount();
      else {
        if (_isRetired) result = retiredAmount();
        else result = normalPayAmount();
      }
    }
    return result;
  }

  // =>
  // 函数中的条件逻辑（conditional logic）使人难以看清正常的执行路径。
  // 使用卫语句（guard clauses）表现所有特殊情况。
  double getPayAmount1() {
    if (_isDead) return deadAmount();
    if (_isSeparated) return separatedAmount();
    if (_isRetired) return retiredAmount();
    return normalPayAmount();
  }

  boolean _isDead;//死亡
  boolean _isSeparated;//驻外
  boolean _isRetired;//退休

  double deadAmount() {
    return 0.0;
  }

  double separatedAmount() {
    return 0.0;
  }

  double retiredAmount() {
    return 0.0;
  }

  double normalPayAmount() {
    return 0.0;
  }
}
