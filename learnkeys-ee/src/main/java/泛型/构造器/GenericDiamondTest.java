package 泛型.构造器;

/**
 * @author zhouT
 * @date 2019/3/12 17:58
 */
public class GenericDiamondTest {
  public static void main(String[] args) {
    // MyClass类声明中的E形参是String类型
    // 泛型构造器中声明的T参数是Integer类型
    MyClass<String> m1 = new MyClass<String>(5);

    // 显式指定泛型构造器中声明的T形参是Integer类型
    MyClass<String> m2 = new <Integer>MyClass<String>(5);

    // MyClass类声明中的E形参是String类型
    // 如果显式指定泛型构造器中声明的T形参是Integer类型
    // 此时不能用“菱形”语法，代码错误
    // MyClass<String> m3 = new <Integer> MyClass<>(5);
  }
}

class MyClass<E> {
  public <T> MyClass(T t) {
    System.out.println("t的参数值为：" + t);
  }
}
