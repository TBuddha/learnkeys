package chapter1_1;

/**
 * @author zhout
 * @date 2020/9/16 18:07
 */
public class Ex20 {

  // 编写一个递归的静态方法计算ln(N!)的值，
  // 背景知识：
  // ln是数学中的对数符号。
  // 数学领域自然对数用ln表示，前一个字母是小写的L（l），不是大写的i（I）。
  // ln 即自然对数 ln=loge a。
  // 以e为底数的对数通常用于ln，而且e还是一个超越数。
  // N!是N的阶乘

  // 对数的运算法则：两个正数的积的对数，等于同一底数的这两个数的对数的和，即
  // log_a MN = log_a M + log_a N
  // 得ln(N!) = ln1 + ln2 + ln3 + ln4 + ... + ln(N) = 详情见MD

  public static double logarithmic(int N) {
    if (N == 0) return 0;
    if (N == 1) return 0;
    return (logarithmic(N - 1) + Math.log(N));
  }

  public static void main(String[] args) {
    System.out.println(logarithmic(10));
    System.out.println(logarithmic(1));
  }
}
