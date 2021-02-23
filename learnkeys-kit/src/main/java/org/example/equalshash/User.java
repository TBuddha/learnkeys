package org.example.equalshash;

import com.google.common.collect.Sets;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhout
 * @date 2021/2/22 14:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String name;
  private Integer age;
  private Integer sex;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || o.getClass() != getClass()) {
      return false;
    }
    User user = (User) o;
    if (this.getName() != null ? !this.getName().equals(user.getName()) : user.getName() != null) {
      return false;
    }
    if (this.getAge() != null ? !this.getAge().equals(user.getAge()) : user.getAge() != null) {
      return false;
    }
    return true;
    //return user.getAge().equals(age) && user.getName().equals(name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  public static void main(String[] args) {
    User user1 = new User("a", 18, 1);
    User user2 = new User("a", 18, 1);
    User user3 = new User("a", 19, 1);

    Set<User> set = Sets.newHashSet();
    set.add(user1);
    set.add(user2);
    System.out.println(set.add(user3));
    System.out.println(set);
  }
}
