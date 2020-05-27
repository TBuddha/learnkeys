package p3典型的静态方法实现;

/**
 * @author zhout
 * @date 2020/5/26 16:26
 */
class Demo {

  // 计算一个整数的绝对值
  public static int abs(int x) {
    if (x < 0) return -x;
    else return x;
  }

  // 判定一个数是否是素数
  public static boolean isPrime(int N) {
    if (N < 2) return false;
    for (int i = 2; i * i <= N; i++) if (N % i == 0) return false;
    return true;
  }

  // 计算平方根（牛顿迭代法）
  public static double sqrt(double c) {
    if (c < 0) return Double.NaN;
    double err = 1e-15;
    double t = c;
    while (Math.abs(t - c / t) > err * t) t = (c / t + t) / 2.0;
    return t;
  }

  // 计算直角三角形的斜边
  public static double hypotenuse(double a, double b) {
    return Math.sqrt(a * a + b * b);
  }

  // 计算调和级数
  public static double H(int N) {
    double sum = 0.0;
    for (int i = 1; i <= N; i++) sum += 1.0 / i;
    return sum;
  }

  public static void main(String[] args) {
    System.out.println("abs = " + abs(-9));
    System.out.println("isPrime = " + isPrime(19));
    System.out.println("sqrt = " + sqrt(15));
    System.out.println("hypotenuse = " + hypotenuse(3, 4));
    System.out.println("H = " + H(3));
  }
}
