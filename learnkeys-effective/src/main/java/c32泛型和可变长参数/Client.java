package c32泛型和可变长参数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoutao
 * @date 2020/3/11 18:09
 */
class Client {

  static void dangerous(List<String>... stringLists) {
    List<Integer> intList = new ArrayList<>();
    Object[] objects = stringLists;
    objects[0] = intList; // Heap pollution
    String s = stringLists[0].get(0); // ClassCastException
  }

  static void foo(String... args) {}

  public static void main(String[] args) {
    // foo("1", "2");
    List<String> list1 = new ArrayList<>();
    dangerous(list1);
  }
}
