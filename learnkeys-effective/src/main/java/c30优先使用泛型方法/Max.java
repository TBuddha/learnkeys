package c30优先使用泛型方法;

import java.util.Collection;
import java.util.Objects;

/**
 * @author zhoutao
 * @date 2020/3/6 15:33
 */
class Max {
  // Returns max value in a collection - uses recursive type bound
  public static <E extends Comparable<E>> E max(Collection<E> c) {
    if (c.isEmpty()) throw new IllegalArgumentException("Empty collection");
    E result = null;
    for (E e : c) if (result == null || e.compareTo(result) > 0) result = Objects.requireNonNull(e);
    return result;
  }
}
