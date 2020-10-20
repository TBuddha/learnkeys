package org.example.c9简化条件表达式.p6以多态取代条件式;

/**
 * Replace Conditional with Polymorphism（以多态取代条件式）。
 * 你手上有个条件式，它根据对象型别的不同而选择不同的行为。
 * 将这个条件式的每个分支放进一个subclass 内的覆写函数中，然后将原始函数声明为抽象函数（abstract method）。
 *
 * @author zhout
 * @date 2020/4/27 10:17
 */
class Demo {

  //  double getSpeed() {
  //    switch (_type) {
  //      case EUROPEAN:
  //        return getBaseSpeed();
  //      case AFRICAN:
  //        return getBaseSpeed() - getLoadFactor() * _numberOfCoconuts;
  //      case NORWEGIAN_BLUE:
  //        return (_isNailed) ? 0 : getBaseSpeed(_voltage);
  //    }
  //    throw new RuntimeException ("Should be unreachable");
  //  }
}
