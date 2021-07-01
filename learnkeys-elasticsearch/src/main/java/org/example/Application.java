package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhout
 * @date 2021/4/15 12:05
 */
@SpringBootApplication(scanBasePackages = "org.example")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
