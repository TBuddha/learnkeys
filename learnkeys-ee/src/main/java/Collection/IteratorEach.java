package Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author zhoutao
 * @date 2019/6/12 15:58
 */
public class IteratorEach {
  public static void main(String[] args) {
    Collection collections = new HashSet();
    collections.add("a");
    collections.add("b");
    collections.add("c");
    collections.add("d");
    Iterator iterator = collections.iterator();
    iterator.forEachRemaining(obj -> System.out.println(obj));
  }
}
