package com.zhout.影片出租.after;

/**
 * @author zhout
 * @date 2020/3/26 16:00
 */
abstract class Price {
  abstract int getPriceCode(); // 取得价格代号

  abstract double getCharge(int daysRented);

//  int getFrequentRenterPoints(int daysRented) {
//    if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
//      return 2;
//    else
//      return 1;
//  }

  //子类NewReleasePrice 复写方法
  int getFrequentRenterPoints(int daysRented){
    return 1;
  }
}

class ChildrensPrice extends Price {
  int getPriceCode() {
    return Movie.CHILDRENS;
  }

  double getCharge(int daysRented) {
    double result = 1.5;
    if (daysRented > 3) result += (daysRented - 3) * 1.5;
    return result;
  }
}

class NewReleasePrice extends Price {
  int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  double getCharge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  int getFrequentRenterPoints(int daysRented) {
    return (daysRented > 1) ? 2: 1;
  }
}

class RegularPrice extends Price {
  int getPriceCode() {
    return Movie.REGULAR;
  }

  double getCharge(int daysRented) {
    double result = 2;
    if (daysRented > 2) result += (daysRented - 2) * 1.5;
    return result;
  }
}
