package Collection.Collections;

import java.util.*;

/**
 * @author zhoutao
 * @date 2019/6/20 18:08
 */
public class SynchronizedTest {
  public static void main(String[] args) {
    // 下面程序创建了四个同步的集合对象
    Collection c = Collections.synchronizedCollection(new ArrayList<>());
    List<String> list = Collections.synchronizedList(new ArrayList<>());
    Set s = Collections.synchronizedSet(new HashSet<>());
    Map m = Collections.synchronizedMap(new HashMap<>());
  }
}
