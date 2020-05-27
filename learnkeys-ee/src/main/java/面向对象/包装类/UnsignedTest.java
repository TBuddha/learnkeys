package 面向对象.包装类;

/**
 * @author zhouT
 * @date 2019/5/15 16:18
 */
public class UnsignedTest {
  public static void main(String[] args) {
    byte b = -3;
    System.out.println(Byte.toUnsignedInt(b));

    System.out.println(Integer.parseUnsignedInt("ab", 16));

    System.out.println(Integer.toUnsignedString(-12, 16));

    System.out.println(Integer.divideUnsigned(-2, 4));

    System.out.println(Integer.remainderUnsigned(-2, 8));
  }
}
