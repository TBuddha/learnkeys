package reflect.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhoutao
 * @date 2019/8/14 11:08
 */
interface Person {

  void walk();

  void sayHello(String name, Integer age);
}

class MyInvocationHandler implements InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("正在执行的方法:" + method);
    if (args != null) {
      System.out.println("下面是执行该方法时传入的实参:");
      for (Object val : args) {
        System.out.println(val);
      }
    } else {
      System.out.println("调用该方法无需实参！");
    }
    return null;
  }
}

class ProxyTest {

  public static void main(String[] args) throws Exception {
    // 创建一个InvocationHandler对象
    InvocationHandler handler = new MyInvocationHandler();

    // 使用指定的InvocationHandler来生成一个动态代理对象
    Person p =
        (Person)
            Proxy.newProxyInstance(
                Person.class.getClassLoader(), new Class[] {Person.class}, handler);

    // 调用动态代理对象的walk()和sayHello()方法
    p.walk();
    p.sayHello("FM", 11);
  }
}
