package com.zhout.c9简化条件表达式.p2合并条件式;

/**
 * Consolidate Conditional Expression（合并条件式）
 *
 * @author zhout
 * @date 2020/4/26 16:17
 */
class Demo {

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
  // =>将这些测试合并为一个条件式，并将这个条件式提炼成为一个独立函数
  //  double disabilityAmount1() {
  //    if (isNotEligibleForDisability()) return 0;
  //    // compute the disability amount
}
