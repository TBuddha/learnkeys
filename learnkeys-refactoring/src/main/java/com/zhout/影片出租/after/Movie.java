package com.zhout.影片出租.after;

/**
 * @author zhout
 * @date 2020/3/26 11:21
 */
public class Movie {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title; // 名称

  // private int _priceCode; // 价格（代号）
  private Price _price;

  //  public Movie(String title, int priceCode) {
  //    _title = title;
  //    _priceCode = priceCode;
  //  }
  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode); // 译注：这就是一个set method
  }

  public int getPriceCode() { // 取得价格代号
    return _price.getPriceCode();
  }

  public void setPriceCode(int arg) { // 设定价格代号
    switch (arg) {
      case REGULAR:
        _price = new RegularPrice();
        break;
      case CHILDRENS:
        _price = new ChildrensPrice();
        break;
      case NEW_RELEASE:
        _price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("Incorrect Price Code");
    }
  }

  public String getTitle() {
    return _title;
  }

  double getCharge(int daysRented) {
    return _price.getCharge(daysRented);
  }

  int getFrequentRenterPoints(int daysRented) {
    return _price.getFrequentRenterPoints(daysRented);
  }
}
