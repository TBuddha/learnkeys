package org.example.c6重新组织函数.p4以查询取代临时变量;

/**
 * 你的程序以一个临时变量（temp）保存某一表达式的运算结果。
 * 将这个表达式提炼到一个独立函数（译注：所谓查询式，query）中。
 * 将这个临时变量的所有「被引用点」替换为「对新函数的调用」。新函数可被其他函数使用。
 *
 * @author zhout
 * @date 2020/4/13 16:12
 */
class Demo {

  private int _quantity;

  private int _itemPrice;

  double getPrice() {
    int basePrice = _quantity * _itemPrice;
    if (basePrice > 1000) return basePrice * 0.95;
    else return basePrice * 0.98;
  }

  // 将这个表达式提炼到一个独立函数（译注：所谓查询式，query）中
  double getPrice1() {
    if (basePrice() > 1000) return basePrice() * 0.95;
    else return basePrice() * 0.98;
  }

  // 把临时变量声明为final
  double getPrice2() {
    final int basePrice = _quantity * _itemPrice;
    final double discountFactor;
    if (basePrice > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice * discountFactor;
  }

  // 替换临时变量
  double getPrice3() {
    final int basePrice = basePrice();
    final double discountFactor;
    if (basePrice > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice * discountFactor;
  }

  // 把临时变量basePrice的第一个引用点替换掉
  double getPrice4() {
    final int basePrice = basePrice();
    final double discountFactor;
    if (basePrice() > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice * discountFactor;
  }

  // 把basePrice临时变量的声明式一并摘除：
  double getPrice5() {
    final double discountFactor;
    if (basePrice() > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice() * discountFactor;
  }

  // 以类似办法提炼出一个discountFactor()
  double getPrice6() {
    final double discountFactor = discountFactor();
    return basePrice() * discountFactor;
  }

  // final 把临时变量basePrice替换为一个查询式
  double getPrice7() {
    return basePrice() * discountFactor();
  }

  private int basePrice() {
    return _quantity * _itemPrice;
  }

  private double discountFactor() {
    if (basePrice() > 1000) return 0.95;
    else return 0.98;
  }
}
