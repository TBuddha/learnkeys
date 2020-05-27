package annotation.示例;

import java.lang.reflect.Method;

/**
 * @author zhoutao
 * @date 2019/6/21 14:53
 */
public class ProcessorTest {

  public static void process(String clazz) throws ClassNotFoundException {
    int passed = 0;
    int failed = 0;
    // 遍历clazz对应的类里的所有方法
    for (Method method : Class.forName(clazz).getMethods()) {
      // 如果使用了@Testable修饰
      if (method.isAnnotationPresent(Testable.class)) {
        try {
          method.invoke(null);
          passed++;
        } catch (Exception e) {
          System.out.println("方法：" + method + "运行失败，异常：" + e.getCause());
          // 异常计数+构建器
          failed++;
        }
      }
    }
    System.out.println("共运行了：" + (passed + failed) + "个方法");
    System.out.println("成功" + passed);
    System.out.println("失败" + failed);
  }
}
