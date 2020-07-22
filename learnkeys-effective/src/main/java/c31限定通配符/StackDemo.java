package c31限定通配符;

import java.util.Collection;
import java.util.Stack;

/**
 * @author zhoutao
 * @date 2020/3/6 16:04
 */
class StackDemo<E> extends Stack<E> {

  // pushAll method without wildcard type - deficient!
  public void pushAll(Iterable<E> src) {
    for (E e : src) push(e);
  }

  // popAll method without wildcard type - deficient!
  public void popAll(Collection<E> dst) {
    while (!isEmpty()) dst.add(pop());
  }

  public static void main(String[] args) {
//    StackDemo<Number> numberStack = new StackDemo<>();
//    List<Integer> integers = Lists.newArrayList(12, 3, 1);
//    numberStack.pushAll(integers);

//    StackDemo<Number> numberStack = new StackDemo<Number>();
//    Collection<Object> objects = new ArrayList<>();
//    numberStack.popAll(objects);

  }
}
