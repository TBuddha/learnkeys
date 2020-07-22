package c29优先考虑泛型;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author zhoutao
 * @date 2020/3/5 10:23
 */
class Stack3<E> {

  private Object[] elements;

  private int size = 0;

  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  public Stack3() {
    elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(E e) {
    ensureCapacity();
    elements[size++] = e;
  }

  public E pop() {
    if (size == 0) throw new EmptyStackException();
    @SuppressWarnings("unchecked")
    E result = (E) elements[--size];
    elements[size] = null; // 消除过时的参考
    return result;
  }

  private void ensureCapacity() {
    if (elements.length == size) elements = Arrays.copyOf(elements, 2 * size + 1);
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    for (String arg : args) stack.push(arg);
    while (!stack.isEmpty()) System.out.println(stack.pop().toUpperCase());
  }
}
