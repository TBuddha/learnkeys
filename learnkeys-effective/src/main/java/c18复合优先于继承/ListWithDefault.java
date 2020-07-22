package c18复合优先于继承;

import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/12/25 10:41
 */
class ListWithDefault<E> extends ForwardingList<E> {

  private final E defaultValue;
  private final List<E> delegate;

  private ListWithDefault(List<E> delegate, E defaultValue) {
    this.delegate = delegate;
    this.defaultValue = defaultValue;
  }

  @Override
  protected List<E> delegate() {
    return delegate;
  }

  @Override
  public E get(int index) {
    E v = super.get(index);
    return (v == null ? defaultValue : v);
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public Iterator<E> iterator() {
    final Iterator<E> iter = super.iterator();
    return new ForwardingIterator<E>() {
      @Override
      protected Iterator<E> delegate() {
        return iter;
      }

      @Override
      public E next() {
        E v = super.next();
        return (v == null ? defaultValue : v);
      }
    };
  }

  public static void main(String[] args) {
    List<String> names = new ListWithDefault<>(

        Arrays.asList("Alice", null, "Bob", "Carol", null),
        "UNKNOWN"
    );

    for (String name : names) {
      System.out.println(name);
    }
    // Alice
    // UNKNOWN
    // Bob
    // Carol
    // UNKNOWN

    System.out.println(names);
    // [Alice, null, Bob, Carol, null]
  }

  /*@Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class User {

    private String name;
    private Integer age;
  }

  public static void main(String[] args) {
    User user1 = new User("a", null);
    User user2 = new User();
    User defaultUser = new User("默认", 18);

    List<User> users = new ListWithDefault<>(Lists.newArrayList(user1, user2), defaultUser);
    for (User user : users) {
      System.out.println(user);
    }
  }*/
}

