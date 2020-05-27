package lambda.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoutao
 * @date 2019/6/20 17:07
 */
public class MapTest {
  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.forEach((key, value) -> System.out.println(key + "--" + value));
  }
}
