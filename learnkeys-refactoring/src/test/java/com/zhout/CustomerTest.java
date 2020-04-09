package com.zhout;

import com.zhout.影片出租.after.Customer;
import com.zhout.影片出租.after.Movie;
import com.zhout.影片出租.after.Rental;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/3/26 16:20
 */
public class CustomerTest {
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
