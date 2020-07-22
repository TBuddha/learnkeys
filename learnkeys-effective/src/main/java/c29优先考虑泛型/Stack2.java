package c29优先考虑泛型;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author zhoutao
 * @date 2020/3/5 10:15
 */
class Stack2<E> {

  private E[] elements;

  private int size = 0;

  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  @SuppressWarnings("unchecked")
  public Stack2() {
    elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(E e) {
    ensureCapacity();
    elements[size++] = e;
  }

  public E pop() {
    if (size == 0) throw new EmptyStackException();
    E result = elements[--size];
    elements[size] = null; // 消除过时的参考
    return result;
  }

  private void ensureCapacity() {
    if (elements.length == size) elements = Arrays.copyOf(elements, 2 * size + 1);
  }
}
