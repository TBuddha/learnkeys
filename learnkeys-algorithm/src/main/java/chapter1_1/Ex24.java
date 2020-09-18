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
  // 使用你的程序计算 1 111 111 和 1 234 567 的最大公约数。
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
    // 此题考察的边界问题
    System.out.println("result: " + euclid(10, 0));
    System.out.println("result: " + euclid(24, 105));
  }

  // ==============================================//
  // 在处理公约数 过程中插入语句，有弊端
  //  1.a<b,会多翻转一次结果，2.a=0或b=0会出现错误
  //  public static int gcd(int p,int q) {
  //    if (q == 0) return p;
  //    int r = p % q;
  //    System.out.println("p = " + p + " , q = " + q);
  //    return gcd(q,r);
  //  }
  // ==============================================//

  // ---------------------------------------------------------------------------------------------------- //

  // 欧几里得算法是，计算两个非负整数p和q的最大公约数：
  // 若q是0，则最大公约数为p。
  // 否则，将p除以q得到余数r，p和q的最大公约数即为q和r的最大公约数。
  public static int gcd(int p, int q) {
    if (q == 0) return p;
    int r = p % q;
    return gcd(q, r);
  }

  // 扩展欧几里得算法，除了计算a、b两个整数的最大公约数，此算法还能找到整数x、y（其中一个很可能是负数）。
  // 通常谈到最大公因子时, 我们都会提到一个非常基本的事实:
  // 给予二整数 a 与 b, 必存在有整数 x 与 y 使得ax + by = gcd(a,b)。
  // 有两个数a,b，对它们进行辗转相除法，可得它们的最大公约数——这是众所周知的。
  // 然后，收集辗转相除法中产生的式子，倒回去，可以得到ax+by=gcd(a,b)的整数解。
  public static long[] ex_gcd(long a, long b) {
    long ans;
    long[] result = new long[3];
    if (b == 0) {
      result[0] = a;
      result[1] = 1;
      return result;
    }
    long[] temp = ex_gcd(b, a % b);
    ans = temp[0];
    result[0] = ans;
    result[1] = temp[2];
    result[2] = temp[1] - (a / b) * temp[2];
    return result;
  }

  @Test
  public void test() {
    Assert.assertEquals(Arrays.toString(ex_gcd(25, 10)), "[5, 1, -2]");
    // 最大公约数为5，切满足gcd(a,b)=ax+by，5=25×1+10×-2
  }
}
