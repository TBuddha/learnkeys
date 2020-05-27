package Collection;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author zhoutao
 * @date 2019/6/12 15:23
 */
public class CollectionTest {
  public static void main(String[] args) {
    Collection collection = new HashSet();
    collection.add("a");
    collection.add("b");
    collection.add("c");
    collection.forEach(obj -> System.out.println(obj));
  }
}
