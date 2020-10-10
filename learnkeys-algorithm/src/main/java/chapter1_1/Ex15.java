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

  // 这道题如果只是看题目的话，绝对会把你绕晕，但如果你看函数的话，一下就豁然开朗了：histogram（直方图），
  // 对的，这道题目其实就是让你去实现一个直方图。关于直方图详细，请看：Ex32

  // 因此这道题也就有两种解法，一种是按题目上的字面信息解法，另外一种就是我们通过直方图的定义来解答。
  // 解法1
  public static int[] histogram(int[] a, int M) {
    int[] b = new int[M];
    int n = 0;
    int m = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < a.length; j++) {
        if (i == a[j]) {
          n++;
        }
        b[i] = n;
      }
      n = 0;
    }
    for (int i = 0; i < M; i++) {
      m = m + b[i];
    }
    return b;
  }

  // 解法2：
  public static int[] histogram2(int[] arr, int M) {
    int[] h = new int[M];
    for (int value : arr) if (value < M) h[value]++;
    return h;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 11, 12};
    int M = 13;
    int[] b = histogram(a, M);
    int[] b2 = histogram2(a, M);

    System.out.println("调用函数后获取的数组：");
    for (int value : b) {
      System.out.println(value);
    }
    System.out.println("b2调用函数后获取的数组：");
    for (int value : b2) {
      System.out.println(value);
    }
  }
}
