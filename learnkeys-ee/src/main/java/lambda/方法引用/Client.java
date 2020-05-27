package lambda.方法引用;

/**
 * @author zhoutao
 * @date 2019/5/27 18:16
 */
@FunctionalInterface
interface Converter {
  Integer convert(String from);
}

@FunctionalInterface
interface MyTest {
  String test(String a, int b, int c);
}

public class Client {
  public static void main(String[] args) {
    // Converter converter1 = from -> Integer.valueOf(from);
    Converter converter1 = Integer::valueOf;
    Integer val = converter1.convert("99");
    System.out.println(val);

    // Converter converter2 = from -> "fkit.org".indexOf(from);
    Converter converter2 = "fkit.org"::indexOf;
    Integer value = converter2.convert("it");
    System.out.println(value);

    // MyTest mt = (a, b, c) -> a.substring(b, c);
    MyTest mt = String::substring;
    String str = mt.test("java内置 version", 2, 7);
    System.out.println(str);
  }
}
