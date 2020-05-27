package 泛型.方法;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhouT
 * @date 2019/3/12 16:53
 */
public class RightTest {
  // 声明一个泛型方法，该泛型方法中带一个T形参
  static <T> void test(Collection<? extends T> from, Collection<T> to) {
    for (T ele : from) {
      to.add(ele);
    }
  }

  public static void main(String[] args) {
    List<Object> objects = new ArrayList<Object>();
    List<String> strings = new ArrayList<String>();
    // 下面代码将产生编译错误
    test(strings, objects);
  }
}
