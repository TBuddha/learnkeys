package c31限定通配符;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * @author zhoutao
 * @date 2020/3/6 16:31
 */
class StackDemo2<E> extends Stack<E> {

  // Wildcard type for a parameter that serves as an E producer
  public void pushAll(Iterable<? extends E> src) {
    for (E e : src) push(e);
  }

  // Wildcard type for parameter that serves as an E consumer
  public void popAll(Collection<? super E> dst) {
    while (!isEmpty()) dst.add(pop());
  }

  public static void main(String[] args) {
    StackDemo2<Number> numberStack = new StackDemo2<>();
    List<Integer> integers = Lists.newArrayList(12, 3, 1);
    numberStack.pushAll(integers);

    StackDemo2<Number> numberStack2 = new StackDemo2<Number>();
    Collection<Object> objects = Lists.newArrayList(1, 2);
    numberStack.popAll(objects);
  }
}
