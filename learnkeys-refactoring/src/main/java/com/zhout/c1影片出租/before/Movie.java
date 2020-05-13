package com.zhout.c1影片出租.before;

/**
 * @author zhout
 * @date 2020/3/26 11:21
 */
class Movie {
  public static final int CHILDRENS = 2; // 儿童片
  public static final int REGULAR = 0; // 普通片
  public static final int NEW_RELEASE = 1; // 新片

  private String _title; // 名称
  private int _priceCode; // 价格（代号）

  public Movie(String title, int priceCode) {
    _title = title;
    _priceCode = priceCode;
  }

  public int getPriceCode() {
    return _priceCode;
  }

  public void setPriceCode(int arg) {
    _priceCode = arg;
  }

  public String getTitle() {
    return _title;
  }
}
