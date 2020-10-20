package org.example.c1影片出租.after;

import org.junit.Test;

/**
 * @author zhout
 * @date 2020/3/26 16:20
 */
class CustomerTest {
  @Test
  public void statement() {
    Customer customer = new Customer("John");
    String title = "Titanic";
    int priceCode = 2;
    int _daysRented = 7;

    Movie movie = new Movie(title, priceCode);
    Rental rental = new Rental(movie, _daysRented);

    customer.addRental(rental);
    String result = customer.statement();
    System.out.println(result);
  }
}
