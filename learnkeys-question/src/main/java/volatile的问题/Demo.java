package volatile的问题;

/**
 * @author zhout
 * @date 2020/10/9 15:39
 *     <p>https://www.v2ex.com/t/712592#reply21
 */
class Demo {
  static long a = 0;

  static long p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16;

  static volatile long b = 0;

  public static void main(String[] args) throws InterruptedException {

    new Thread(
            () -> {
              while (a == 0) {
                // long x = b; // 为什么这里读 b, 能让线程同时读到 a 的最新值?  如果注释这行, a 就读不到
                // 设置了 -Djava.compiler=NONE 就可以解决了
              }
              System.out.println("a=" + a);
            })
        .start();

    Thread.sleep(100);

    a = 1;
  }

  // > 如果注释这行, a 就读不到。
  //
  // 这简单，你把 JIT 关掉就行了（如果你也是 open JDK ）。
  // 估计是 JVM 直接帮你把 while （ a == 0 ）替换成 while （ 0 == 0 ）或者 while （ true ）了。
  //
  // 所以说这跟可见性根本就没有关系，只跟 JVM 的具体实现有关
  // 设置了 -Djava.compiler=NONE 就可以解决了
}
