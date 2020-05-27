package annotation.示例;

/**
 * @author zhoutao
 * @date 2019/6/21 14:49
 */
public class MyTest {

  @Testable
  public static void m1() {}

  public static void m2() {}

  @Testable
  public static void m3() {
    throw new IllegalArgumentException("参数异常");
  }

  public static void m4() {}

  @Testable
  public static void m5() {}

  public static void m6() {}

  @Testable
  public static void m7() {
    throw new IllegalArgumentException("业务异常");
  }

  public static void m8() {}
}
