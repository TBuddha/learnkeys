package org.example.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author zhout
 * @date 2020/11/16 10:28
 */
@Slf4j
public class OptionalTest {

  @Test
  public void ex1() {
    String name = "John";
    Optional<String> opt = Optional.ofNullable(name);
    Assert.assertEquals("John", opt.get());
  }

  @Test
  public void ex2() {
    User user = new User("john@gmail.com", "1234");
    Optional<User> opt = Optional.ofNullable(user);
    Assert.assertTrue(opt.isPresent());
    Assert.assertEquals(user.getEmail(), opt.get().getEmail());
  }

  @Test
  public void ex3() {
    User user = null;
    User user2 = new User("anna@gmail.com", "1234");

    User result = Optional.ofNullable(user).orElse(user2);
    Assert.assertEquals(user2.getEmail(), result.getEmail());

    // 最终结果
    User res = Optional.ofNullable(user).orElseGet(() -> user2);
    System.out.println(res);
  }

  @Test
  public void ex4() {
    //orElse() 和 orElseGet()
    //https://www.cnblogs.com/zhangboyu/p/7580262.html
  }


  @Data
  @AllArgsConstructor
  private static class User {
    private String email;
    private String pwd;
  }
}
