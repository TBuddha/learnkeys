package org.example.c1影片出租.before;

/**
 * @author zhout
 * @date 2020/3/26 11:22
 */
class Rental { // 租赁
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
}
