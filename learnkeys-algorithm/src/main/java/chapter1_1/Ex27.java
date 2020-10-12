package chapter1_1;

import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/18 10:27
 */
public class Ex27 {

  // 二项分布。估计用以下代码计算binomial(100, 50,0.25)将会产生的递归调用次数:
  /*
  public static double binomial(int N, int k, double p) {
    if (N == 0 && k == 0) return 1.0;
    if (N < 0 || k < 0) return 0.0;
    return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
  }
  */

  // 1、因原题N和K太大，程序吃力，这里将binomial(100, 50,0.25)修改为binomial(10, 5,0.25)为例：
  public static int count = 0;

  public static double binomial(int n, int k, double p) {
    count++;
    if (n == 0 && k == 0) return 1.0;
    if (n < 0 || k < 0) return 0.0;
    return (1.0 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
  }

  @Test
  public void test1() {
    int n = 10000, k = 50;
    double p = 0.25;

    //    double b = binomial(n, k, p);
    //    System.out.println(b);
    //    System.out.println(count);

    // ---------------------------------------//
    double better = binomial2(n, k, p);
    System.out.println(better);
    // ---------------------------------------//
  }

  // 将已经计算过的值保存在数组中并给出一个更好的实现：官网实现
  // memoization
  public static double binomial2(int N, int k, double p) {
    double[][] b = new double[N + 1][k + 1];

    // base cases
    for (int i = 0; i <= N; i++) b[i][0] = Math.pow(1.0 - p, i);
    b[0][0] = 1.0;

    // recursive formula
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= k; j++) {
        b[i][j] = p * b[i - 1][j - 1] + (1.0 - p) * b[i - 1][j];
      }
    }
    return b[N][k];
  }

  private static double[][] MATRIX;

  public static double binomial3(int N, int k, double p) {
    MATRIX = new double[N + 1][k + 1];
    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= k; j++) {
        MATRIX[i][j] = -1;
      }
    }
    return bin(N, k, p);
  }

  private static double bin(int N, int k, double p) {
    if (N == 0 && k == 0) {
      return 1.0;
    }
    if (N < 0 || k < 0) {
      return 0.0;
    }
    if (MATRIX[N][k] == -1) {
      MATRIX[N][k] = (1.0 - p) * bin(N - 1, k, p) + p * bin(N - 1, k - 1, p);
    }
    return MATRIX[N][k];
  }

  @Test
  public void test2() {
    int n = 10000, k = 50;
    double p = 0.25;
    System.out.println(binomial3(n, k, p));
  }
  // 总结 详细看MD
  // binomial2()为最佳实现，binomial3(3)大数据会崩
}
