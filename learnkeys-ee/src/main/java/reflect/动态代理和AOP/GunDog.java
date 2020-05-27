package reflect.动态代理和AOP;

/**
 * @author zhoutao
 * @date 2019/8/14 11:25
 */
public class GunDog implements Dog {

  // info方法实现，仅仅打印一个字符串
  @Override
  public void info() {
    System.out.println("我是一只猎狗");
  }

  // run方法实现，仅仅打印一个字符串
  @Override
  public void run() {
    System.out.println("我奔跑迅速");
  }
}
