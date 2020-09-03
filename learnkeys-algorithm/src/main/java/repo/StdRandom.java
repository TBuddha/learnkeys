package repo;

import java.util.Random;

/**
 * @author zhout
 * @date 2020/7/22 14:32
 */
public class StdRandom {

  private static Random random; // pseudo-random number generator
  private static long seed; // pseudo-random number generator seed

  // static initializer
  static {
    // this is how the seed was set in Java 1.4
    seed = System.currentTimeMillis();
    random = new Random(seed);
  }

  // don't instantiate
  private StdRandom() {}

  /** Sets the seed of the psedurandom number generator. 设置伪随机数生成器的种子 */
  public static void setSeed(long s) {
    seed = s;
    random = new Random(seed);
  }

  /** Returns the seed of the psedurandom number generator. */
  public static long getSeed() {
    return seed;
  }

  /** Return real number uniformly in [0, 1) 在[0，1）中统一返回实数 */
  public static double uniform() {
    return random.nextDouble();
  }

  /**
   * Returns an integer uniformly between 0 (inclusive) and N (exclusive). 返回一个整数（均匀地在0（含）和N（不含）之间）
   *
   * @throws IllegalArgumentException if <tt>N <= 0</tt>
   */
  public static int uniform(int N) {
    if (N <= 0) throw new IllegalArgumentException("Parameter N must be positive");
    return random.nextInt(N);
  }

  ///////////////////////////////////////////////////////////////////////////
  //  STATIC METHODS BELOW RELY ON java.util.random ONLY INDIRECTLY VIA
  //  THE STATIC METHODS ABOVE.
  //  静态方法仅间接依赖于java.util.random
  ///////////////////////////////////////////////////////////////////////////

  /**
   * Returns a real number uniformly in [0, 1). 以[0，1）统一返回实数。
   *
   * @deprecated clearer to use {@link #uniform()}
   */
  public static double random() {
    return uniform();
  }

  /**
   * Returns an integer uniformly in [a, b). 在[a，b）中统一返回整数
   *
   * @throws IllegalArgumentException if <tt>b <= a</tt>
   * @throws IllegalArgumentException if <tt>b - a >= Integer.MAX_VALUE</tt>
   */
  public static int uniform(int a, int b) {
    if (b <= a) throw new IllegalArgumentException("Invalid range");
    if ((long) b - a >= Integer.MAX_VALUE) throw new IllegalArgumentException("Invalid range");
    return a + uniform(b - a);
  }

  /**
   * Returns a real number uniformly in [a, b). 在[a，b）中统一返回实数。
   *
   * @throws IllegalArgumentException unless <tt>a < b</tt>
   */
  public static double uniform(double a, double b) {
    if (!(a < b)) throw new IllegalArgumentException("Invalid range");
    return a + uniform() * (b - a);
  }

  /**
   * Returns a boolean, which is true with probability p, and false otherwise.
   * 返回一个布尔值，以概率p为true，否则为false。
   *
   * @throws IllegalArgumentException unless <tt>p >= 0.0</tt> and <tt>p <= 1.0</tt>
   */
  public static boolean bernoulli(double p) {
    if (!(p >= 0.0 && p <= 1.0))
      throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
    return uniform() < p;
  }

  /**
   * Returns a boolean, which is true with probability .5, and false otherwise.
   * 返回一个布尔值，它以0.5的概率为true，否则为false。
   */
  public static boolean bernoulli() {
    return bernoulli(0.5);
  }

  /** Returns a real number with a standard Gaussian distribution. 返回具有标准高斯分布的实数。 */
  public static double gaussian() {
    // use the polar form of the Box-Muller transform
    double r, x, y;
    do {
      x = uniform(-1.0, 1.0);
      y = uniform(-1.0, 1.0);
      r = x * x + y * y;
    } while (r >= 1 || r == 0);
    return x * Math.sqrt(-2 * Math.log(r) / r);

    // Remark:  y * Math.sqrt(-2 * Math.log(r) / r)
    // is an independent random gaussian
  }

  /**
   * Returns a real number from a gaussian distribution with given mean and stddev
   * 从具有给定均值和stddev的高斯分布中返回实数
   */
  public static double gaussian(double mean, double stddev) {
    return mean + stddev * gaussian();
  }

  /**
   * Returns an integer with a geometric distribution with mean 1/p. 返回具有均值为1 / p的几何分布的整数。
   *
   * @throws IllegalArgumentException unless <tt>p >= 0.0</tt> and <tt>p <= 1.0</tt>
   */
  public static int geometric(double p) {
    if (!(p >= 0.0 && p <= 1.0))
      throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
    // using algorithm given by Knuth
    return (int) Math.ceil(Math.log(uniform()) / Math.log(1.0 - p));
  }

  /**
   * Return an integer with a Poisson distribution with mean lambda. 返回具有均值lambda的泊松分布的整数。
   *
   * @throws IllegalArgumentException unless <tt>lambda > 0.0</tt> and not infinite
   */
  public static int poisson(double lambda) {
    if (!(lambda > 0.0)) throw new IllegalArgumentException("Parameter lambda must be positive");
    if (Double.isInfinite(lambda))
      throw new IllegalArgumentException("Parameter lambda must not be infinite");
    // using algorithm given by Knuth
    // see http://en.wikipedia.org/wiki/Poisson_distribution
    int k = 0;
    double p = 1.0;
    double L = Math.exp(-lambda);
    do {
      k++;
      p *= uniform();
    } while (p >= L);
    return k - 1;
  }

  /**
   * Returns a real number with a Pareto distribution with parameter alpha. 返回带有参数alpha的Pareto分布的实数。
   *
   * @throws IllegalArgumentException unless <tt>alpha > 0.0</tt>
   */
  public static double pareto(double alpha) {
    if (!(alpha > 0.0))
      throw new IllegalArgumentException("Shape parameter alpha must be positive");
    return Math.pow(1 - uniform(), -1.0 / alpha) - 1.0;
  }

  /** Returns a real number with a Cauchy distribution. 返回具有柯西分布的实数。 */
  public static double cauchy() {
    return Math.tan(Math.PI * (uniform() - 0.5));
  }

  /**
   * Returns a number from a discrete distribution: i with probability a[i]. throws
   * IllegalArgumentException if sum of array entries is not (very nearly) equal to <tt>1.0</tt>
   * throws IllegalArgumentException unless <tt>a[i] >= 0.0</tt> for each index <tt>i</tt>
   *
   * 从离散分布中返回一个数字：i的概率为a [i]。
   * 如果数组条目的总和（几乎）不等于<tt> 1.0 </ tt>，则抛出IllegalArgumentException
   *
   */
  public static int discrete(double[] a) {
    double EPSILON = 1E-14;
    double sum = 0.0;
    for (int i = 0; i < a.length; i++) {
      if (!(a[i] >= 0.0))
        throw new IllegalArgumentException("array entry " + i + " must be nonnegative: " + a[i]);
      sum = sum + a[i];
    }
    if (sum > 1.0 + EPSILON || sum < 1.0 - EPSILON)
      throw new IllegalArgumentException(
          "sum of array entries does not approximately equal 1.0: " + sum);

    // the for loop may not return a value when both r is (nearly) 1.0 and when the
    // cumulative sum is less than 1.0 (as a result of floating-point roundoff error)
    while (true) {
      double r = uniform();
      sum = 0.0;
      for (int i = 0; i < a.length; i++) {
        sum = sum + a[i];
        if (sum > r) return i;
      }
    }
  }

  /**
   * Returns a real number from an exponential distribution with rate lambda.
   * 从具有指数λ的指数分布中返回实数。
   *
   * @throws IllegalArgumentException unless <tt>lambda > 0.0</tt>
   */
  public static double exp(double lambda) {
    if (!(lambda > 0.0)) throw new IllegalArgumentException("Rate lambda must be positive");
    return -Math.log(1 - uniform()) / lambda;
  }

  /** Rearrange the elements of an array in random order.
   * 以随机顺序重新排列数组的元素。
   */
  public static void shuffle(Object[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int r = i + uniform(N - i); // between i and N-1
      Object temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  /** Rearrange the elements of a double array in random order. */
  public static void shuffle(double[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int r = i + uniform(N - i); // between i and N-1
      double temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  /** Rearrange the elements of an int array in random order. */
  public static void shuffle(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int r = i + uniform(N - i); // between i and N-1
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  /** Rearrange the elements of the subarray a[lo..hi] in random order. */
  public static void shuffle(Object[] a, int lo, int hi) {
    if (lo < 0 || lo > hi || hi >= a.length) {
      throw new IndexOutOfBoundsException("Illegal subarray range");
    }
    for (int i = lo; i <= hi; i++) {
      int r = i + uniform(hi - i + 1); // between i and hi
      Object temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  /** Rearrange the elements of the subarray a[lo..hi] in random order. */
  public static void shuffle(double[] a, int lo, int hi) {
    if (lo < 0 || lo > hi || hi >= a.length) {
      throw new IndexOutOfBoundsException("Illegal subarray range");
    }
    for (int i = lo; i <= hi; i++) {
      int r = i + uniform(hi - i + 1); // between i and hi
      double temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  /** Rearrange the elements of the subarray a[lo..hi] in random order.
   * 以随机顺序重新排列子数组a[lo..hi]的元素。 */
  public static void shuffle(int[] a, int lo, int hi) {
    if (lo < 0 || lo > hi || hi >= a.length) {
      throw new IndexOutOfBoundsException("Illegal subarray range");
    }
    for (int i = lo; i <= hi; i++) {
      int r = i + uniform(hi - i + 1); // between i and hi
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  /** Unit test. */
  public static void main(String[] args) {
    //    int N = Integer.parseInt(args[0]);
    //    if (args.length == 2) StdRandom.setSeed(Long.parseLong(args[1]));
    //    double[] t = {.5, .3, .1, .1};
    //
    //    System.out.println("seed = " + StdRandom.getSeed());
    //    for (int i = 0; i < N; i++) {
    //      System.out.printf("%2d ", uniform(100));
    //      System.out.printf("%8.5f ", uniform(10.0, 99.0));
    //      System.out.printf("%5b ", bernoulli(.5));
    //      System.out.printf("%7.5f ", gaussian(9.0, .2));
    //      System.out.printf("%2d ", discrete(t));
    //      System.out.println();
    //    }
    //
    //    String[] a = "A B C D E F G".split(" ");
    //    for (String s : a) System.out.print(s + " ");
    //    System.out.println();
    if (args.length == 2) StdRandom.setSeed(Long.parseLong(args[1]));
    double[] t = {.5, .3, .1, .1};

    System.out.println("seed = " + StdRandom.getSeed());

    System.out.printf("%2d ", uniform(100));
    System.out.printf("%8.5f ", uniform(10.0, 99.0));
    System.out.printf("%5b ", bernoulli(.5));
    System.out.printf("%7.5f ", gaussian(9.0, .2));
    System.out.printf("%2d ", discrete(t));
    System.out.println();

    String[] a = "A B C D E F G".split(" ");
    for (String s : a) System.out.print(s + " ");
    System.out.println();
  }
}
