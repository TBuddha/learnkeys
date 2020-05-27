package 面向对象.内部类;

/**
 * @author zhoutao
 * @date 2019/5/24 16:33
 */
interface Product {
  double getPrice();

  String getName();
}

public class AnonymousTest {
  public void test(Product p) {
    System.out.println("购买了一个" + p.getName() + "，花掉了" + p.getPrice());
  }

  public static void main(String[] args) {
    AnonymousTest ta = new AnonymousTest();
    // 调用test方法时，需要传入一个Product参数，此处传入其匿名实现类的实例
    ta.test(
        new Product() {
          public double getPrice() {
            return 567.8;
          }

          public String getName() {
            return "AGP显卡";
          }
        });
  }
}
