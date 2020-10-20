package chapter1_1.p2典型的数组处理代码;

import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/5/26 15:54
 */
class Demo {

  public static int max(int[] array) {
    int max = array[0];
    for (int value : array) {
      if (value > max) max = value;
    }
    return max;
  }

  public static double avg(int[] array) {
    double sum = 0.0;
    for (int value : array) sum += value;
    return sum / array.length;
  }

  public static int[] copy(int[] a) {
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; ++i) b[i] = a[i];
    // System.arraycopy(a, 0, b, 0, a.length);
    return b;
  }

  public static int[] reverse(int[] array) {
    int N = array.length;
    for (int i = 0; i < N / 2; ++i) {
      int temp = array[i];
      array[i] = array[N - 1 - i];
      array[N - 1 - i] = temp;
    }
    return array;
  }

  // 矩阵相乘（方阵）：a[][] * b[][] = c[][]
  public static int[][] matrix(int[][] a, int[][] b) {
    int N = a.length;
    int[][] c = new int[N][N];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; i < N; ++i) {
        for (int k = 0; k < N; k++) { // 计算行i和列j的点乘
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println("max = " + max(new int[] {12, 3, 8}));
    System.out.println("avg = " + avg(new int[] {12, 3, 8}));
    System.out.println("copy = " + Arrays.toString(copy(new int[] {12, 3, 8})));
    System.out.println("reverse = " + Arrays.toString(reverse(new int[] {12, 3, 8})));
  }
}
