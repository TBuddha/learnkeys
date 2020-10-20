package org.example.c9简化条件表达式.p5以卫语句取代嵌套条件式;

/**
 * 想像一个薪资系统，其中以特殊规则处理死亡员工、驻外员工、退休员工的薪资。这些情况不常有，但的确偶而会出现。
 *
 * @author zhout
 * @date 2020/4/27 09:50
 */
class Demo2 {

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

  // 使用『卫语句」来取代这些检查，以提高程序清晰度。我可以逐一引入卫语句。让我们从最上面的条件检查动作开始
  double getPayAmount2() {
    double result;
    if (_isDead) return deadAmount();
    if (_isSeparated) result = separatedAmount();
    else {
      if (_isRetired) result = retiredAmount();
      else result = normalPayAmount();
    }
    return result;
  }

  // 然后，继续下去，仍然一次替换一个检查动作：
  double getPayAmount3() {
    double result;
    if (_isDead) return deadAmount();
    if (_isSeparated) return separatedAmount();
    if (_isRetired) result = retiredAmount();
    else result = normalPayAmount();
    return result;
  }

  // 然后是最后一个：
  double getPayAmount4() {
    double result;
    if (_isDead) return deadAmount();
    if (_isSeparated) return separatedAmount();
    if (_isRetired) return retiredAmount();
    result = normalPayAmount();
    return result;
  }

  // 此时，result 变量已经没有价值了，所以我把它删掉：
  double getPayAmount5() {
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
