package reflect.加载连接初始化;

/**
 * @author zhoutao
 * @date 2019/7/17 17:12
 */
class MyTest {
  static {
    System.out.println("静态初始化块...");
  }

  // 使用一个字符串直接量为static final属性赋值
  static final String compileConstant = "zhout";

  // 采用系统当前时间为static final属性赋值
  // static final String compileConstant = System.currentTimeMillis() + "";

}

public class CompileConstantTest {
  public static void main(String[] args) {
    // 访问、输出MyTest中的compileConstant属性
    System.out.println(MyTest.compileConstant);
  }
}
