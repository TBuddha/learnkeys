package 面向对象.内部类;

/**
 * @author zhoutao
 * @date 2019/5/24 17:39
 */
interface A {
  void test();
}

public class ATest {
  public static void main(String[] args) {
    int age = 0;
    A a =
        new A() {
          public void test() {
            // java8以前下面语句将提示错误：匿名内部类内访问局部变量必须使用final修饰
            // java8开始 匿名内部类、局部内部类允许访问非final的局部变量
            System.out.println(age);
          }
        };
    a.test();
  }
}
