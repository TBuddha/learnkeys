package org.example.c8重新组织数据.p15以值域取代子类;

/**
 * 两个subclasses 之间惟一的区别就是：它们以不同的方式实现了 Person 所声明的抽象函数getCode() ，返回不同的硬编码常量（所以getCode()
 * 是个常量函数[Beck]）。我应该将这两个怠惰subclasses 的去掉
 *
 * @author zhout
 * @date 2020/4/26 11:20
 */
class Male extends Person {
  boolean isMale() {
    return true;
  }

  char getCode() {
    return 'M';
  }
}
