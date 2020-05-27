package reflect.创建对象;

import java.lang.reflect.Constructor;

/**
 * @author zhoutao
 * @date 2019/8/12 18:00
 */
public class CreateJFrame {

  public static void main(String[] args) throws Exception {
    // 获取JFrame对应的Class对象
    Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
    // 获取JFrame中带一个字符串参数的构造器
    Constructor constructor = jframeClazz.getConstructor(String.class);
    // 调用Constructor的newInstance方法创建对象
    Object obj = constructor.newInstance("测试窗口");
    // 输出JFrame对象
    System.out.println(obj);
  }
}
