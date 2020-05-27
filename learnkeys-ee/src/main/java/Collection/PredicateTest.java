package Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * @author zhoutao
 * @date 2019/6/12 17:01
 */
public class PredicateTest {
  public static void main(String[] args) {
    Collection strs = new HashSet();
    strs.add("a");
    strs.add("bdsadgghjhfgjhgc");
    strs.add("c");
    strs.add("d");
    // strs.removeIf(ele -> ((String) ele).length() < 10);
    // System.out.println(strs);

    // 统计包含c的数量
    System.out.println(calAll(strs, ele -> ((String) ele).contains("c")));
    // 长度大于10的数量
    System.out.println(calAll(strs, ele -> ((String) ele).length() > 10));
  }

  private static int calAll(Collection strs, Predicate predicate) {
    int total = 0;
    for (Object obj : strs) {
      // 使用Predicatede的test()方法判断该对象是否满足Predicate指定的条件
      if (predicate.test(obj)) {
        total++;
      }
    }
    return total;
  }
}
