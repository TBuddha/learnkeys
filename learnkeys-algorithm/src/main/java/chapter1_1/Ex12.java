package chapter1_1;

import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:54
 */
public class Ex12 {
  @Test
  public void test() {
    int[] a = new int[10];
    for (int i = 0; i < 10; i++) {
      a[i] = 9 - i;
      System.out.println(a[i]);
    }
    System.out.println("------");
    for (int i = 0; i < 10; i++) {
      a[i] = a[a[i]];
      System.out.println(a[i]);
    }
    System.out.println("======");
    for (int i = 0; i < 10; i++) System.out.println(i);
  }
}
