package 面向对象.final宏替换;

/**
 * @author zhouT
 * @date 2019/5/20 10:36
 */
public class FinalReplaceTest {
  public static void main(String[] args) {
    final String book = "文字:" + 99.0;
    final String book2 = "文字:" + String.valueOf(99.0);
    System.out.println(book == "文字:99.0");
    System.out.println(book2 == "文字:99.0");
  }
}
