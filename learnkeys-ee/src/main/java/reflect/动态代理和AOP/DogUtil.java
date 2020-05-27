package reflect.动态代理和AOP;

/**
 * @author zhoutao
 * @date 2019/8/14 11:27
 */
public class DogUtil {

  // 第一个拦截器方法
  public void method1() {
    System.out.println("=====模拟第一个通用方法=====");
  }

  // 第二个拦截器方法
  public void method2() {
    System.out.println("=====模拟通用方法二=====");
  }
}
