package 泛型.java8改进的类型判断;

/**
 * @author zhouT
 * @date 2019/4/12 15:48
 */
public class InterfaceTest {
  public static void main(String[] args) {
    MyUtil<String> ls = MyUtil.nil();

    MyUtil<String> mu = MyUtil.<String>nil();

    MyUtil.cons(42, MyUtil.nil());

    MyUtil.cons(42, MyUtil.<Integer>nil());

    String s = MyUtil.<String>nil().head();
  }
}

class MyUtil<E> {
  public static <Z> MyUtil<Z> nil() {
    return null;
  }

  public static <Z> MyUtil<Z> cons(Z head, MyUtil<Z> tail) {
    return null;
  }

  E head() {
    return null;
  }
}
