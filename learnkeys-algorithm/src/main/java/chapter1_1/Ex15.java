package chapter1_1;

import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:55
 */
public class Ex15 {
  // 编写一个静态方法 histogram()，接受一个整型数组 a[] 和一个整数 M 为参数并返回一个大小为 M 的数组，
  // 其中第 i 个元素的值为整数 i <在参数数组中>出现的次数。
  // 如果 a[] 中的值均在 0 到 M-1之间，返回数组中所有元素之和应该和 a.length 相等
  @Test
  public void test() {
    // int[] a = { 1, 1, 2, 3, 1, 7, 5, 3, 2, 2, 2 };
    int[] a = {1, 1, 1, 2, 2, 2, 3, 3, 5, 6, 7, 9, 9, 9, 9};
    print(histogram(a, 8), a.length);
  }

  public static void print(int[] b, int a) {
    int sum = 0;
    for (int i : b) {
      sum += i;
      System.out.print(i + " ");
    }
    System.out.println("\n返回数组中所有元素的和a.length是否相等？" + (sum == a));
  }

  public static int[] histogram(int[] a, int M) {
    int[] result = new int[M];
    for (int i = 0; i < a.length; i++) {
      if (a[i] >= 0 && a[i] < M) {
        result[a[i]]++;
      }
    }
    return result;
  }
}
