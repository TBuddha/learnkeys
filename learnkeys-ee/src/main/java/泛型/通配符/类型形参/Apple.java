package 泛型.通配符.类型形参;

/**
 * @author zhouT
 * @date 2019/3/12 11:14
 */
public class Apple<T extends Number & java.io.Serializable> {
  T col;

  public static void main(String[] args) {
    Apple<Integer> ai = new Apple<Integer>();
    Apple<Double> ad = new Apple<Double>();
    // 下面代码将引起编译异常
    // 因为String类型传给T形参，但String不是Number的子类型。
    // Apple<String> as = new Apple<String>();
  }
}
