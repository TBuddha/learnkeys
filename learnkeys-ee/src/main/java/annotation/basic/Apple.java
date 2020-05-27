package annotation.basic;

/**
 * @author zhoutao
 * @date 2019/6/21 10:25
 */
public class Apple extends Fruit {

  @Override // 检查覆盖方法
  @Deprecated // 标记已过时
  public void info() {
    System.out.println("..");
  }
}

class Client {
  public static void main(String[] args) {
    new Apple().info();
  }
}
