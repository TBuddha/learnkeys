package reflect.动态代理和AOP;

/**
 * @author zhoutao
 * @date 2019/8/14 14:54
 */
public class Test {

  public static void main(String[] args) throws Exception {
    // 创建一个原始的GunDog对象，作为target
    Dog target = new GunDog();
    // 以指定的target来创建动态代理
    Dog dog = (Dog) MyProxyFactory.getProxy(target);
    dog.info();
    dog.run();
  }
}
