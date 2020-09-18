package chapter1_1;

/**
 * @author zhout
 * @date 2020/9/16 18:07
 */
public class Ex20 {

  // 编写一个递归的静态方法计算ln(N!)的值，
  // 由对数基本公式：log_a MN = log_a M + log_a N
  // 得ln(N!) = ln1 + ln2 + ln3 + ln4 + ... + ln(N) = 详情见MD
  public static double ln(int N) {
    if (N == 0) {
      return 0;
    } else {
      return Math.log(N) + ln(N - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(ln(10));
    System.out.println(ln(1));
  }
}
