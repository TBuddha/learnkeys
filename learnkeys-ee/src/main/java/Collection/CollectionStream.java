package Collection;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author zhoutao
 * @date 2019/6/12 17:58
 */
public class CollectionStream {
  public static void main(String[] args) {
    Collection<String> strs = new HashSet();
    strs.add("a");
    strs.add("bdsadgghjhfgjhgc");
    strs.add("c");
    strs.add("d");
    // 统计包含c的数量
    // System.out.println(strs.stream().filter(ele -> ele.contains("c")).count());

    // 长度大于10的数量
    // System.out.println(strs.stream().filter(ele -> (ele.length() > 10)).count());

    strs.stream().mapToInt(ele -> ele.length()).forEach(System.out::println);
  }
}
