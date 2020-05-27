package reflect.加载连接初始化;

/**
 * @author zhoutao
 * @date 2019/7/17 17:05
 */
public class Test {

  static {
    // 使用静态初始化块为b变量指定出初始值
    b = 6;
    System.out.println("----------");
  }

  // 声明a变量时指定初始值
  static int a = 5;
  static int b = 9;
  static int c;

  public static void main(String[] args) {
    System.out.println(Test.b);
  }
}
