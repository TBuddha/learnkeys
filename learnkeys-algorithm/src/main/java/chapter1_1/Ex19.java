package chapter1_1;

import org.junit.Test;
import repo.StdOut;

import java.math.BigInteger;

/**
 * @author zhout
 * @date 2020/9/16 17:11
 */
public class Ex19 {

  // 计算机用这段程序在一个小时之内能够得到 F(N) 结果的最大 N 值是多少？
  // 开发 F(N) 的一个更好的实现，用数组保存已经计算过的值。
  //  public static long F(int N) {
  //    if (N == 0) return 0;
  //    if (N == 1) return 1;
  //    return F(N - 1) + F(N - 2);
  //  }
  //
  //  public static void main(String[] args) {
  //    // for (int N = 0; N < 100; N++) StdOut.println(N + " " + F(N));
  //    System.out.println(F(3));
  //  }

  public static long[] F(int N) {
    long[] fibonacci = new long[N + 1];
    if (N == 0) {
      return fibonacci;
    }
    fibonacci[1] = 1;
    if (N == 1) {
      return fibonacci;
    }
    for (int i = 2; i <= N; i++) {
      fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
    }
    return fibonacci;
  }

  // 由于long只能表示-9223372036854775808~9223372036854775807之间（2^64 ~ 2^64  - 1）的数
  // 所以该题的答案会超出范围，可以采用BigInteger来解决该问题
  public static BigInteger[] F1(int N) {
    BigInteger[] fibonacci = new BigInteger[N + 1];

    fibonacci[0] = BigInteger.valueOf(0);
    if (N == 0) {
      return fibonacci;
    }
    fibonacci[1] = BigInteger.valueOf(1);
    if (N == 1) {
      return fibonacci;
    }
    // 这里不再用递归，而是用公式计算，效率高
    for (int i = 2; i <= N; i++) {
      fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
    }
    return fibonacci;
  }

  @Test
  public void test() {
    long[] fibonacci = F(99);
    for (int N = 0; N < fibonacci.length; N++) {
      StdOut.println(N + " " + fibonacci[N]);
    }
    System.out.println("------------------------------------------");
    BigInteger[] fibonacci1 = F1(99);
    for (int N = 0; N < fibonacci1.length; N++) {
      StdOut.println(N + " " + fibonacci1[N]);
    }
  }
}
