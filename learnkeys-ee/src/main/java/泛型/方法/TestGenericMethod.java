package 泛型.方法;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhouT
 * @date 2019/3/12 14:50
 */
public class TestGenericMethod {
  // 声明一个泛型方法，该泛型方法中带一个T形参，
  static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
    for (T o : a) {
      c.add(o);
    }
  }

  public static void main(String[] args) {
    Object[] objects = new Object[100];
    Collection<Object> collectionObj = new ArrayList<Object>();
    // 下面代码中T代表Object类型
    fromArrayToCollection(objects, collectionObj);

    String[] str = new String[100];
    Collection<String> collectionStr = new ArrayList<String>();
    // 下面代码中T代表String类型
    fromArrayToCollection(str, collectionStr);

    // 下面代码中T代表Object类型
    fromArrayToCollection(str, collectionObj);

    Integer[] integers = new Integer[100];
    Float[] floats = new Float[100];
    Number[] numbers = new Number[100];
    Collection<Number> collectionNumber = new ArrayList<Number>();
    // 下面代码中T代表Number类型
    fromArrayToCollection(integers, collectionNumber);
    // 下面代码中T代表Number类型
    fromArrayToCollection(floats, collectionNumber);
    // 下面代码中T代表Number类型
    fromArrayToCollection(numbers, collectionNumber);
    // 下面代码中T代表String类型
    fromArrayToCollection(numbers, collectionObj);

    // 下面代码中T代表String类型，但na是一个Number数组，
    // 因为Number既不是String类型，也不是它的子类，所以出现编译错误
    // fromArrayToCollection(numbers, collectionStr);
  }
}
