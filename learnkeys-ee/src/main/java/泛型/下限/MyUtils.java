package 泛型.下限;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhouT
 * @date 2019/3/12 18:21
 */
public class MyUtils {
  private static <T> T copy(Collection<? super T> dest, Collection<T> src) {
    T last = null;
    for (T ele : src) {
      last = ele;
      dest.add(ele);
    }
    return last;
  }

  public static void main(String[] args) {
    List<Number> ln = new ArrayList<Number>();
    List<Integer> li = new ArrayList<Integer>();
    li.add(5);
    Integer last = copy(ln, li);
    System.out.println(ln);
  }
}
