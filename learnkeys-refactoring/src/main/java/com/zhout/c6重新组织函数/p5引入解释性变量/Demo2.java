package com.zhout.c6重新组织函数.p5引入解释性变量;

/**
 * @author zhout
 * @date 2020/4/13 16:42
 */
class Demo2 {
  private int _quantity;

  private int _itemPrice;

  double price() {
    // price is base price - quantity discount + shipping
    return _quantity * _itemPrice
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(_quantity * _itemPrice * 0.1, 100.0);
  }

  // 把一部分计算的结果放进 一个临时变量中：basePrice
  double price2() {
    // price is base price - quantity discount + shipping
    final double basePrice = _quantity * _itemPrice;
    return basePrice
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(_quantity * _itemPrice * 0.1, 100.0);
  }

  // 继续把_quantity * _itemPrice 替换为临时变量：basePrice
  double price3() {
    // price is base price - quantity discount + shipping
    final double basePrice = _quantity * _itemPrice;
    return basePrice
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(basePrice * 0.1, 100.0);
  }

  // 批发折扣（quantity discount）的计算提炼出来，将结果赋予临时变量 quantityDiscount
  double price4() {
    // price is base price - quantity discount + shipping
    final double basePrice = _quantity * _itemPrice;
    final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    return basePrice - quantityDiscount + Math.min(basePrice * 0.1, 100.0);
  }

  // 把运费（shipping）计算提炼出来，将运算结果赋予临时变量shipping。 同时我可以删掉代码中的注释，因为现在代码已经可以完美表达自己的意义了
  double price5() {
    final double basePrice = _quantity * _itemPrice;
    final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
    final double shipping = Math.min(basePrice * 0.1, 100.0);
    return basePrice - quantityDiscount + shipping;
  }

  /** ************运用 Extract Method处理上述范例****** */
  double price_ext() {
    // price is base price - quantity discount + shipping
    return _quantity * _itemPrice
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(_quantity * _itemPrice * 0.1, 100.0);
  }

  // 底价计算提炼到一个独立函数中
  double price_ext2() {
    // price is base price - quantity discount + shipping
    return basePrice()
        - Math.max(0, _quantity - 500) * _itemPrice * 0.05
        + Math.min(basePrice() * 0.1, 100.0);
  }

  // final
  double price_ext3() {
    return basePrice() - quantityDiscount() + shipping();
  }

  private double basePrice() {
    return _quantity * _itemPrice;
  }

  private double quantityDiscount() {
    return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
  }

  private double shipping() {
    return Math.min(basePrice() * 0.1, 100.0);
  }
}
