package Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author zhoutao
 * @date 2019/6/12 15:25
 */
public class IteratorTest {
  public static void main(String[] args) {
    Collection collections = new HashSet();
    collections.add("a");
    collections.add("b");
    collections.add("c");
    collections.add("d");
    Iterator iterator = collections.iterator();
    while (iterator.hasNext()) {
      String str = (String) iterator.next();
      System.out.println(str);
      if (str.equals("c")) {
        iterator.remove();
      }
      // 对str变量赋值，不会改变集合元素本身
      str = "新值";
    }
    System.out.println(collections);
  }
}
