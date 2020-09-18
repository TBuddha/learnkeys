package chapter1_1;

/**
 * @author zhout
 * @date 2020/9/16 16:50
 */
public class Ex03 {
  // 编写一个程序，从命令行得到三个整数参数。如果它们都相等则打印 equal ，否则打印 not equal
  public static void main(String[] args) {
    String str = args[0].equals(args[1]) && args[1].equals(args[2]) ? "equal" : "not equal";
    System.out.println(str);
  }
}
