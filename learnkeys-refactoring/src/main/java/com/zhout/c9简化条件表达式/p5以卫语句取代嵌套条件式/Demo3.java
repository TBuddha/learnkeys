package com.zhout.c9简化条件表达式.p5以卫语句取代嵌套条件式;

/**
 * 将条件逆反（Reversing the Conditions） 审阅本书初稿时，Joshua Kerievsky 指出：你常常可以将条件表达式逆反，从而实现Replace Nested
 * Conditional with Guard Clauses。为了拯救我可怜的想像力，他还好心帮我想了个例子
 *
 * @author zhout
 * @date 2020/4/27 09:55
 */
class Demo3 {

  public double getAdjustedCapital() { // 获得调整后的资本
    double result = 0.0;
    if (_capital > 0.0) {
      if (_intRate > 0.0 && _duration > 0.0) {
        result = (_income / _duration) * ADJ_FACTOR;
      }
    }
    return result;
  }

  public double getAdjustedCapital2() {
    double result = 0.0;
    // 这次在插入卫语句（guard clauses）时，我需要将相应的条件逆反过来
    if (_capital <= 0.0) return result;
    if (_intRate > 0.0 && _duration > 0.0) {
      result = (_income / _duration) * ADJ_FACTOR;
    }
    return result;
  }

  public double getAdjustedCapital3() {
    double result = 0.0;
    if (_capital <= 0.0) return result;
    if (!(_intRate > 0.0 && _duration > 0.0)) return result;
    // 下一个条件稍微复杂一点，所以我分两步进行逆反。首先加入一个"logical-NOT"操作：
    result = (_income / _duration) * ADJ_FACTOR;
    return result;
  }

  // 但是在这样的条件式中留下一个"logical-NOT"，会把我的脑袋拧成一团乱麻，所以我把它简化成下面这样：
  public double getAdjustedCapital4() {
    double result = 0.0;
    if (_capital <= 0.0) return result;
    if (_intRate <= 0.0 || _duration <= 0.0) return result;
    result = (_income / _duration) * ADJ_FACTOR;
    return result;
  }

  // 这时候我比较喜欢在卫语句（guard clause）内返回一个明确值，因为这样我可以一目了然地看到卫语句返回的失败结果。
  // 此外，这种时候我也会考虑使用Replace Magic Number with Symbolic Constant (用符号常量替换魔幻数)。
  public double getAdjustedCapital5() {
    double result = 0.0;
    if (_capital <= 0.0) return 0.0;
    if (_intRate <= 0.0 || _duration <= 0.0) return 0.0;
    result = (_income / _duration) * ADJ_FACTOR;
    return result;
  }

  // 完成替换之后，我同样可以将临时变量移除：
  public double getAdjustedCapital6() {
    if (_capital <= 0.0) return 0.0;
    if (_intRate <= 0.0 || _duration <= 0.0) return 0.0;
    return (_income / _duration) * ADJ_FACTOR;
  }

  double _capital; // 人均
  double _intRate; // 一次性付息证券的利率
  double _duration; // 持续时间
  double _income; // 收入
  double ADJ_FACTOR; // 因子
}
