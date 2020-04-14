package com.zhout.c1影片出租.after;

/**
 * @author zhout
 * @date 2020/3/26 11:22
 */
public class Rental {
  private Movie _movie; // 影片
  private int _daysRented; // 租期

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  double getCharge() {
    return _movie.getCharge(_daysRented);
  }

  int getFrequentRenterPoints() {
    return _movie.getFrequentRenterPoints(_daysRented);
  }
}
