package chapter1_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/9/17 15:11
 */
public class Ex24 {

  // 给出使用欧几里得算法计算 105 和 24 的最大公约数的过程中得到的一系列 p 和 q 的值。
  // 扩展该算法中的代码得到一个程序Euclid，
  // 从命令行接受两个参数，计算它们的最大公约数并打印出每次调用递归方法时的两个参数。
  // 使用你的程序计算 1111111 和 1234567 的最大公约数。
  public static int euclid(int p, int q) {
    System.out.println("p = " + p + ", q = " + q);
    if (p == 0 || q == 0) {
      return 1;
    }
    if (p < q) {
      int t = p;
      p = q;
      q = t;
    }
    if (p % q == 0) {
      return q;
    } else {
      return euclid(q, p % q);
    }
  }

  public static void main(String[] args) {
    System.out.println("result: " + euclid(105, 24));
    System.out.println("result: " + euclid(1111111, 1234567));
    System.out.println("=========此题考察的边界问题=========");
    System.out.println("result: " + euclid(10, 0));
    System.out.println("result: " + euclid(24, 105));
  }
}
