package org.example.c11处理概括关系.p10塑造模板函数;


/**
 * @author zhout
 * @date 2020/5/12 11:05
 */
class Rental {
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
