package 泛型.通配符;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouT
 * @date 2019/3/8 17:39
 */
public class Client {
  public static void test(List<?> c) {
    for (int i = 0; i < c.size(); i++) {
      System.out.println(c.get(i));
    }
  }

  public static void main(String[] args) {
    List<String> strList = new ArrayList<>();
    test(strList);
  }
}
