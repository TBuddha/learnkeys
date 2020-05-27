package 泛型.方法;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhouT
 * @date 2019/3/12 14:31
 */
public class Test {
  static void test(Object[] a, Collection<Object> c) {
    for (Object o : a) {
      c.add(o);
    }
  }

  public static void main(String[] args) {
    String[] strArr = {"a", "b"};
    List<String> stringList = new ArrayList<>();
    // Collection<String>不能当成Collection<Object>使用，下面代码将产生编译错误
    // common(strArr,stringList);
  }
}
