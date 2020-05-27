package lambda.与匿名内部类的区别;

/**
 * @author zhoutao
 * @date 2019/5/27 19:56
 */
@FunctionalInterface
interface Displayable {

  // 抽象方法和默认方法
  void display();

  default int add(int a, int b) {
    return a + b;
  }
}

public class LambdaAndInner {
  private int age = 12;
  private static String name = "测试";

  public void test() {
    String book = "TheEnd";
    Displayable dis =
        () -> {
          System.out.println("book的局部变量" + book);
          System.out.println("外部类的age实例变量：" + age);
          System.out.println("外部类的name类变量：" + name);
          // System.out.println(add(3,5));
        };
    dis.display();
    System.out.println(dis.add(3, 5));
  }

  public static void main(String[] args) {
    LambdaAndInner li = new LambdaAndInner();
    li.test();
  }
}
