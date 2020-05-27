package reflect.动态代理和AOP;

import java.lang.reflect.Proxy;

/**
 * @author zhoutao
 * @date 2019/8/14 14:50
 */
public class MyProxyFactory {

  // 为指定target生成动态代理对象
  public static Object getProxy(Object target) throws Exception {
    // 创建一个MyInvocationHandler对象
    MyInvocationHandler handler = new MyInvocationHandler();

    // 为MyInvocationHandler设置target对象
    handler.setTarget(target);

    // 创建、并返回一个动态代理
    return Proxy.newProxyInstance(
        target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
  }
}
