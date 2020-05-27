package reflect.class对象;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/7/19 18:19
 */
public class MethodParameterTest {

  public static void main(String[] args) throws Exception {
    Class<Test> clazz = Test.class;

    Method replace = clazz.getMethod("replace", String.class, List.class);

    System.out.println("replace的方法参数个数 " + replace.getParameterCount());

    // 获取replace的所有参数信息
    Parameter[] parameters = replace.getParameters();

    int index = 1;
    for (Parameter p : parameters) {
      /*//是否包含了方法的形参名信息
      if (p.isNamePresent()) {
        System.out.println("---第" + index + "个参数信息---");
        System.out.println("参数名：" + p.getName());
        System.out.println("形参类型：" + p.getType());
        System.out.println("泛型类型：" + p.getParameterizedType());
      }*/
      System.out.println("---第" + index + "个参数信息---");
      System.out.println("参数名：" + p.getName());
      System.out.println("形参类型：" + p.getType());
      System.out.println("泛型类型：" + p.getParameterizedType());
    }
  }
}

class Test {

  public void replace(String str, List<String> list) {}
}
