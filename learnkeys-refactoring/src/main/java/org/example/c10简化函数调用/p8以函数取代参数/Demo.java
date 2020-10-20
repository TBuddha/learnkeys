package org.example.c10简化函数调用.p8以函数取代参数;

/**
 * 以下代码用于计算定单折扣价格。虽然这么低的折扣不大可能出现在现实生活中， 不过作为一个范例，我们暂不考虑这一点：
 *
 * @author zhout
 * @date 2020/5/6 14:47
 */
class Demo {

  public double getPrice() {
    int basePrice = _quantity * _itemPrice;
    // 折扣等级
    int discountLevel;
    if (_quantity > 100) discountLevel = 2;
    else discountLevel = 1;
    double finalPrice = discountedPrice(basePrice, discountLevel);
    return finalPrice;
  }

  private double discountedPrice(int basePrice, int discountLevel) {
    if (discountLevel == 2) return basePrice * 0.1;
    else return basePrice * 0.05;
  }

  int _quantity;
  int _itemPrice;
}

class Demo1 {

  // 首先，我把计算折扣等级（discountLevel）的代码提炼成为一个独立的 getDiscountLevel() 函数：
  public double getPrice() {
    int basePrice = _quantity * _itemPrice;
    int discountLevel = getDiscountLevel();
    double finalPrice = discountedPrice(basePrice, discountLevel);
    return finalPrice;
  }

  private int getDiscountLevel() {
    if (_quantity > 100) return 2;
    else return 1;
  }

  private double discountedPrice(int basePrice, int discountLevel) {
    if (discountLevel == 2) return basePrice * 0.1;
    else return basePrice * 0.05;
  }

  int _quantity;
  int _itemPrice;
}

class Demo2 {

  public double getPrice() {
    int basePrice = _quantity * _itemPrice;
    int discountLevel = getDiscountLevel();
    double finalPrice = discountedPrice(basePrice, discountLevel);
    return finalPrice;
  }

  private int getDiscountLevel() {
    if (_quantity > 100) return 2;
    else return 1;
  }

  // 然后把discountedPrice() 函数中对discountLevel 参数的所有引用点，替换为getDiscountLevel() 函数的调用：
  private double discountedPrice(int basePrice, int discountLevel) {
    if (getDiscountLevel() == 2) return basePrice * 0.1;
    else return basePrice * 0.05;
  }

  int _quantity;
  int _itemPrice;
}

class Demo3 {
  // 此时我就可以使用Remove Parameter 去掉discountLevel 参数了 ：
  public double getPrice() {
    int basePrice = _quantity * _itemPrice;
    // int discountLevel = getDiscountLevel();
    double finalPrice = discountedPrice(basePrice);
    return finalPrice;
  }

  private int getDiscountLevel() {
    if (_quantity > 100) return 2;
    else return 1;
  }

  private double discountedPrice(int basePrice) {
    if (getDiscountLevel() == 2) return basePrice * 0.1;
    else return basePrice * 0.05;
  }

  int _quantity;
  int _itemPrice;
}

class Demo4 {
  // 现在，可以去掉其他非必要的参数和相应的临时变量。最后获得以下代码：
  public double getPrice() {
    return discountedPrice();
  }

  private double getBasePrice() {
    return _quantity * _itemPrice;
  }

  private double discountedPrice() {
    if (getDiscountLevel() == 2) return getBasePrice() * 0.1;
    else return getBasePrice() * 0.05;
  }

  private int getDiscountLevel() {
    if (_quantity > 100) return 2;
    else return 1;
  }

  int _quantity;
  int _itemPrice;
}

class Demo5 {
  // 最后我还可以针对discountedPrice() 函数使用Inline Method：
  private double getPrice() {
    if (getDiscountLevel() == 2) return getBasePrice() * 0.1;
    else return getBasePrice() * 0.05;
  }

  private int getDiscountLevel() {
    if (_quantity > 100) return 2;
    else return 1;
  }

  private double getBasePrice() {
    return _quantity * _itemPrice;
  }

  int _quantity;
  int _itemPrice;
}
