package reflect.动态代理和AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhoutao
 * @date 2019/8/14 14:22
 */
public class MyInvocationHandler implements InvocationHandler {

  // 需要被代理的对象
  private Object target;

  public void setTarget(Object target) {
    this.target = target;
  }

  // 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
  public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
    DogUtil dogUtil = new DogUtil();

    // 执行DogUtil对象中的method1。
    dogUtil.method1();

    // 以target作为主调来执行method方法
    Object result = method.invoke(target, args);

    // 执行DogUtil对象中的method2。
    dogUtil.method2();

    return result;
  }
}
