package org.example.c9简化条件表达式.p2合并条件式;

/**
 * @author zhout
 * @date 2020/4/26 17:10
 */
class OrsDemo {
  Integer _seniority; // 资历
  Integer _monthsDisabled; // 几个月
  boolean _isPartTime; // 是否兼职

  double disabilityAmount() { // 伤残金额
    if (_seniority < 2) return 0;
    if (_monthsDisabled > 12) return 0;
    if (_isPartTime) return 0;
    // compute the disability amount
    return 0;
  }
  // 我们看到一连串的条件检查，它们都做同一件事。对于这样的代码， 上述条件检查等价于一个以"logical-OR"连接起来的语句：
  double disabilityAmount1() {
    if ((_seniority < 2) || (_monthsDisabled > 12) || (_isPartTime)) return 0;
    // compute the disability amount
    return 0;
  }

  // 运用Extract Method 将它提炼成一个独立函数，以函数名称表达该语句所检查的条件
  double disabilityAmount2() {
    if (isNotEligibleForDisability()) return 0;
    // compute the disability amount
    return 0;
  }

  boolean isNotEligibleForDisability() {
    return ((_seniority < 2) || (_monthsDisabled > 12) || (_isPartTime));
  }
}
