package com.zhout.重新组织函数.引入解释性变量;

/**
 * @author zhout
 * @date 2020/4/13 16:42
 */
public class Demo2 {
  private int _quantity;

  private int _itemPrice;

  double price1() {
    // price is base price - quantity discount + shipping
    return _quantity * _itemPrice
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(_quantity * _itemPrice * 0.1, 100.0);
  }

  double price2() {
    // price is base price - quantity discount + shipping
    final double basePrice = _quantity * _itemPrice;
    return basePrice
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(_quantity * _itemPrice * 0.1, 100.0);
  }

  double price3() {
    // price is base price - quantity discount + shipping
    final double basePrice = _quantity * _itemPrice;
    return basePrice
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(basePrice * 0.1, 100.0);
  }

  double price4() {
    // price is base price - quantity discount + shipping
    final double basePrice = _quantity * _itemPrice;
    final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    return basePrice - quantityDiscount + Math.min(basePrice * 0.1, 100.0);
  }

  double price5() {
    final double basePrice = _quantity * _itemPrice;
    final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    final double shipping = Math.min(basePrice * 0.1, 100.0);
    return basePrice - quantityDiscount + shipping;
  }

  // 运用 Extract Method处理上述范例
  double price_ext1() {
    // price is base price - quantity discount + shipping
    return _quantity * _itemPrice
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(_quantity * _itemPrice * 0.1, 100.0);
  }

  double price_ext2() {
    // price is base price - quantity discount + shipping
    return basePrice()
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(basePrice() * 0.1, 100.0);
  }

  private double basePrice() {
    return _quantity * _itemPrice;
  }

  double price_ext3() {
    return basePrice() - quantityDiscount() + shipping();
  }

  private double quantityDiscount() {
    return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
  }

  private double shipping() {
    return Math.min(basePrice() * 0.1, 100.0);
  }
}
