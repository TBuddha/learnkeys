package 泛型.构造器;

/**
 * @author zhouT
 * @date 2019/3/12 17:22
 */
public class GenericConstructor {
  public static void main(String[] args) {
    new Foo("String");
    new Foo(200);
    // 显示指定泛型构造器中的T参数为String
    // 传给Foo构造器的实参也是String对象，完全正确
    new <String>Foo("String");
    // 显示指定泛型构造器中的T参数为String
    // 但传给Foo构造器的实参为Double对象，下面代码出错
    // new <String> Foo(12.3);
  }
}

class Foo {
  public <T> Foo(T t) {
    System.out.println(t);
  }
}
