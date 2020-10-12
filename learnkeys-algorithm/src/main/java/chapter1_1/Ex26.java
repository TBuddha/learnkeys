package chapter1_1;

/**
 * @author zhout
 * @date 2020/9/17 16:12
 */
public class Ex26 {

  // 将三个数字排序。假设 a、b、c 和 t 都是同一种原始数字类型的变量。证明以下代码能够将 a、 b、c 按照升序排列:
  // ------------------------------------ //
  // if (a > b) { t = a; a = b; b = t; }
  // if (a > c) { t = a; a = c; c = t; }
  // if (b > c) { t = b; b = c; c = t; }
  // ------------------------------------ //
  // 解析：这是冒泡排序的一种思路：通过不停交换数字，将小的数冒泡到最上面。

  public static void main(String[] args) {
    inAnAscendingOrder(15, 13, 10);
  }

  /**
   * 1、a>b，那么ab交换位置。
   * 2、a>c,那么ac交换位置，那么此时c已经到第一位，最小。
   * 3、b>c,那么bc交换位置，大的放在最后。
   * 此时 a<b<c
   */
  public static void inAnAscendingOrder(int a, int b, int c) {
    // 15 13 10
    int t;
    if (a > b) {
      t = a;
      a = b;
      b = t;
      // 13 15 10
    }
    if (a > c) {
      // 10 15 13 把最小的挑出来放在第一个
      t = a;
      a = c;
      c = t;
    }
    if (b > c) {
      // 10 13 15 把第二小的挑出来放在第二个，第三个自然是最大的
      t = b;
      b = c;
      c = t;
    }
    System.out.println(a + " " + b + " " + c);
  }
}
