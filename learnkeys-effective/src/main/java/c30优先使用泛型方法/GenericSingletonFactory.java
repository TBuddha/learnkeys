package c30优先使用泛型方法;

import java.util.function.UnaryOperator;

/**
 * @author zhoutao
 * @date 2020/3/6 15:18
 */
class GenericSingletonFactory {

  // Generic singleton factory pattern
  private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

  @SuppressWarnings("unchecked")
  public static <T> UnaryOperator<T> identityFunction() {
    return (UnaryOperator<T>) IDENTITY_FN;
  }

  // Sample program to exercise generic singleton
  public static void main(String[] args) {
    String[] strings = {"jute", "hemp", "nylon"};
    UnaryOperator<String> sameString = identityFunction();
    for (String s : strings) System.out.println(sameString.apply(s));

    Number[] numbers = {1, 2.0, 3L};
    UnaryOperator<Number> sameNumber = identityFunction();
    for (Number n : numbers) System.out.println(sameNumber.apply(n));
  }
}
