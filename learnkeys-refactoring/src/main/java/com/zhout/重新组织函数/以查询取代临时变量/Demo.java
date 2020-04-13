package com.zhout.重新组织函数.以查询取代临时变量;

/**
 * @author zhout
 * @date 2020/4/13 16:12
 */
public class Demo {

  private int _quantity;

  private int _itemPrice;

  double getPrice1() {
    int basePrice = _quantity * _itemPrice;
    if (basePrice > 1000) return basePrice * 0.95;
    else return basePrice * 0.98;
  }

  double getPrice2() {
    if (basePrice() > 1000) return basePrice() * 0.95;
    else return basePrice() * 0.98;
  }

  double getPrice3() {
    final int basePrice = _quantity * _itemPrice;
    final double discountFactor;
    if (basePrice > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice * discountFactor;
  }

  double getPrice4() {
    final int basePrice = basePrice();
    final double discountFactor;
    if (basePrice > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice * discountFactor;
  }

  double getPrice5() {
    final int basePrice = basePrice();
    final double discountFactor;
    if (basePrice() > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice * discountFactor;
  }

  double getPrice6() {
    final double discountFactor;
    if (basePrice() > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice() * discountFactor;
  }

  double getPrice7() {
    final double discountFactor = discountFactor();
    return basePrice() * discountFactor;
  }

  private double discountFactor() {
    if (basePrice() > 1000) return 0.95;
    else return 0.98;
  }

  // final
  double getPrice() {
    return basePrice() * discountFactor();
  }

  private int basePrice() {
    return _quantity * _itemPrice;
  }
}
