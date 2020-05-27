package p1最大公约数;

/**
 * 百科：https://baike.baidu.com/item/%E6%9C%80%E5%A4%A7%E5%85%AC%E7%BA%A6%E6%95%B0
 *
 * @author zhout
 * @date 2020/5/26 14:52
 */
class Demo {

  /** 辗转相除法（欧几里得算法） 计算两个非负整数p和q的最大公约数： 若q是0，则最大公约数为p。 否则，将p除以q得到余数r，p和q的最大公约数即为q和r的最大公约数。 */
  public static int gcd(int p, int q) {
    if (q == 0) return p;
    int r = p % q;
    return gcd(q, r);
  }

  public static void main(String[] args) {
    System.out.println("最大公约数 = " + gcd(16, 12));
  }
}
