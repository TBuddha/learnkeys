package chapter1_1;

/**
 * @author zhout
 * @date 2020/9/24 17:25
 */
public class Ex30 {

  // 数组练习。编写一段程序，创建一个 N×N 的布尔数组 a[][]。
  // 其中当 i 和 j 互质时(没有相同因子)，a[i][j] 为 true，否则为 false。

  /**
   * ·质数又称素数，指在大于1的自然数中，除了1和该数自身外， 无法被其他自然数整除的数（也可定义为只有1与该数本身两个正因数的数）。
   *  大于1的自然数若不是素数，则称之为合数
   * ·1虽不是质数，但与任何正整数都是互质数。
   */
  public static void main(String[] args) {
    int N = 3;
    boolean[][] a = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        a[i][j] = fun(i, j);
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean fun(int p, int q) {
    //考虑边界问题
    if (p == 0 || q == 0) return false;
    if (p == 1 || q == 1) return true;
    int temp, index = 2;
    temp = Math.min(p, q);
    while (index <= temp) {
      if (p % index == 0 && q % index == 0) { // 如果两个数不互质，返回false
        return false;
      }
      index++;
    }
    return true;
  }

  public static int euclid(int p, int q) {
    if (p < q) {
      int t = p;
      p = q;
      q = t;
    }
    if (q == 0) {
      return p;
    } else {
      return euclid(q, p % q);
    }
  }
}
