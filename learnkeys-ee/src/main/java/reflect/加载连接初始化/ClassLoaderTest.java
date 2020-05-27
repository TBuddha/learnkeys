package reflect.加载连接初始化;

/**
 * @author zhoutao
 * @date 2019/7/17 17:18
 */
class Tester {
  static {
    System.out.println("Tester类的静态初始化块...");
  }
}

public class ClassLoaderTest {
  public static void main(String[] args) throws ClassNotFoundException {
    String packageName = Tester.class.getPackage().getName();

    ClassLoader cl = ClassLoader.getSystemClassLoader();
    // 下面语句仅仅是加载Tester类
    cl.loadClass(packageName + ".Tester");
    System.out.println("系统加载Tester类");

    // 下面语句才会初始化Tester类
    Class.forName(packageName + ".Tester");
  }
}
