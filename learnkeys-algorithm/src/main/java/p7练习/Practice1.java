package p7练习;

import org.junit.Assert;
import org.junit.Test;
import repo.StdOut;

import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/9/15 11:16
 */
public class Practice1 {

  @Test
  public void ex1() {
    Assert.assertEquals((0 + 15) / 2, 7);
    Assert.assertEquals(2.0e-6 * 100000000.1, 200.0000002, 0);
    Assert.assertTrue(true && false || true && true);
  }

  @Test
  public void ex2() {
    // 这里需要解释一下，第一题因为0和15都是整型变量，所以结果是整型。
    // 而这里整型和浮点型相加，JVM会自动将整形转为浮点型。
    // 另：如果要精确的小数计算的话，建议使用BigDecimal
    Assert.assertEquals((1 + 2.236) / 2, 1.618, 0.000);

    Assert.assertEquals(1 + 2 + 3 + 4.0, 10.0, 0);

    Assert.assertTrue(4.1 >= 4);
    // !!!
    Assert.assertEquals(1 + 2 + "3", "33");
  }

  // 编写一个程序，从命令行得到三个整数参数。如果它们都相等则打印 equal ，否则打印 not equal
  public static void main(String[] args) {
    String str = args[0].equals(args[1]) && args[1].equals(args[2]) ? "equal" : "not equal";
    System.out.println(str);
  }

  // “编写一段程序，如果 double 类型的变量 x 和 y 都严格位于 0 和 1 之间则打印 true ，否则打印 false 。”
  @Test
  public void ex5() {
    double x = 1.11;
    double y = 0.555;
    System.out.println(x > 0 && x < 1 && y > 0 && y < 1);
  }

  // “下面这段程序会打印出什么”
  @Test
  public void ex6() {
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }

  @Test
  public void ex7a() {
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) t = (9.0 / t + t) / 2.0;
    StdOut.printf("%.5f\n", t);
  }

  @Test
  public void ex7b() {
    int sum = 0;
    for (int i = 1; i < 1000; i++) for (int j = 0; j < i; j++) sum++;
    StdOut.println(sum);
  }

  @Test
  public void ex7c() {
    int sum = 0;
    for (int i = 1; i < 1000; i *= 2) for (int j = 0; j < 1000; j++) sum++;
    StdOut.println(sum);
  }

  @Test
  public void ex8() {
    Assert.assertEquals('b', 'b'); // 直接打印char字符
    Assert.assertEquals('b' + 'c', 197); // 98 + 99 = 197
    Assert.assertEquals((char) ('a' + 4), 101); // 97 + 4 = 101，e的ASCII码是101
  }

  // ------------------------------------------------------------------------------------------------- start
  // “编写一段代码，将一个正整数 N 用二进制表示并转换为一个 String 类型的值 s ”
  // Java 有一个内置方法 Integer.toBinaryString(N) 专门完成这个任务，
  // 但该题的目的就是给出这个方法的其他实现方法。下面就是一个特别简洁的答案：
  @Test
  public void ex9() {
    int N = 1024;
    Assert.assertEquals(toBinaryStr(N), Integer.toBinaryString(N));

    int value = -1024;
    Assert.assertEquals(toBinaryString(value), Integer.toBinaryString(value));
  }

  private String toBinaryStr(int N) {
    String s = "";
    for (int n = N; n > 0; n /= 2) s = (n % 2) + s;
    return s;
  }

  /** 此方法支持正负整数 */
  private static String toBinaryString(int value) {
    if (value == 0) {
      return "0";
    }
    int bufLen = 32;
    int index = bufLen;
    char[] result = new char[bufLen];
    do {
      // 使用 & 符合相对除 2 提升一定性能
      result[--index] = (char) ('0' + (value & 1));
      value = value >>> 1;
    } while (value != 0);
    return new String(result, index, bufLen - index);
  }

  // ------------------------------------------------------------------------------------------------- end

  // ------------------------------------------------------------------------------------------------- start
  // “编写一段代码，打印出一个二维布尔数组的内容。其中，使用 * 表示真，空格表示假。打印出行号和列号。”
  @Test
  public void ex11() {
    boolean[][] boo =
        new boolean[][] {{true, false, false}, {true, true, true}, {true, true, false}};
    printBooleanMatrix(boo);
  }

  private static void printBooleanMatrix(boolean[][] matrix) {
    System.out.print(' ');
    for (int i = 0; i < matrix[0].length; i++) {
      System.out.print(i);
    }
    System.out.println();
    for (int i = 0; i < matrix.length; i++) {
      System.out.print(i);
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] ? '*' : ' ');
      }
      System.out.println();
    }
  }
  // ------------------------------------------------------------------------------------------------- end

  @Test
  public void ex12() {
    int[] a = new int[10];
    for (int i = 0; i < 10; i++) {
      a[i] = 9 - i;
      System.out.println(a[i]);
    }
    System.out.println("------");
    for (int i = 0; i < 10; i++) {
      a[i] = a[a[i]];
      System.out.println(a[i]);
    }
    System.out.println("======");
    for (int i = 0; i < 10; i++) System.out.println(i);
  }

  // ------------------------------------------------------------------------------------------------- start
  // “编写一段代码，打印出一个  行  列的二维数组的转置 （交换行和列）”
  @Test
  public void ex13() {
    int[][] a = {{1, 2, 3}, {4, 5, 6}};
    System.out.println(Arrays.deepToString(a));
    System.out.println("置换结果 :");
    printTransposedMatrix(a);
  }

  private static void printTransposedMatrix(int[][] matrix) {
    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        // System.out.printf("%4d", matrix[j][i]);
        System.out.print(matrix[j][i] + "  ");
      }
      System.out.println();
    }
  }
  // ------------------------------------------------------------------------------------------------- end

  // ------------------------------------------------------------------------------------------------- start
  // “编写一个静态方法lg() ，接受一个整型参数 N，返回不大于 log2N 的最大整数。不要 使用 Math 库”
  // 解释log2N，意义为2的多少次方等于N
  @Test
  public void ex14() {
    int value = 23;
    System.out.println(lg(value) + "==" + lg2(value));
  }

  // Jimmy Sun版本
  private static int lg(int n) {
    int shiftRightCount = 0;
    do {
      n >>= 1;
      shiftRightCount++;
    } while (n != 0);
    return shiftRightCount - 1;
  }

  // Kyson版本
  private static int lg2(int N) {
    int product = 1;
    int x = -1;
    while (product <= N) { // *，把等于的情况也纳入进来，从而避免了在如23>5这种情况的自增导致输出结果为3的情况
      product *= 2;
      x++;
    }
    return x;
  }
  // ------------------------------------------------------------------------------------------------- end

  // ------------------------------------------------------------------------------------------------- start
  // 编写一个静态方法 histogram()，接受一个整型数组 a[] 和一个整数 M 为参数并返回一个大小为 M 的数组，
  // 其中第 i 个元素的值为整数 i <在参数数组中>出现的次数。
  // 如果 a[] 中的值均在 0 到 M-1之间，返回数组中所有元素之和应该和 a.length 相等
  @Test
  public void ex15() {
    // int[] a = { 1, 1, 2, 3, 1, 7, 5, 3, 2, 2, 2 };
    int[] a = {1, 1, 1, 2, 2, 2, 3, 3, 5, 6, 7, 9, 9, 9, 9};
    print(histogram(a, 8), a.length);
  }

  public static void print(int[] b, int a) {
    int sum = 0;
    for (int i : b) {
      sum += i;
      System.out.print(i + " ");
    }
    System.out.println("\n返回数组中所有元素的和a.length是否相等？" + (sum == a));
  }

  public static int[] histogram(int[] a, int M) {
    int[] result = new int[M];
    for (int i = 0; i < a.length; i++) {
      if (a[i] >= 0 && a[i] < M) {
        result[a[i]]++;
      }
    }
    return result;
  }
  // ------------------------------------------------------------------------------------------------- end

  // ------------------------------------------------------------------------------------------------- start
  // “给出 exR1(6) 的返回值”
  @Test
  public void ex16() {
    Assert.assertEquals(exR1(6), "311361142246");
  }

  public static String exR1(int n) {
    if (n <= 0) return "";
    return exR1(n - 3) + n + exR1(n - 2) + n;
  }
  // exR1(6) = exR1(3) + 6 + exR1(4) + 6
  // exR1(4) = exR1(1) + 4 + exR1(2) + 4 = "114224"
  // exR1(3) = exR1(0) + 3 + exR1(1) + 3 = "3113”
  // exR1(2) = exR1(-1) + 2 + exR1(0) + 2 = "22"
  // exR1(1) = exR1(-2) + 1 + exR1(-1) + 1 = "11"
  // n < 1时，exR1(n) = ""
  // 故 exR1(6) = "311361142246"
  // ------------------------------------------------------------------------------------------------- end

  @Test
  public void ex17() {}

  @Test
  public void ex18() {}

  @Test
  public void ex19() {}

  @Test
  public void ex20() {}

  @Test
  public void ex21() {}

  @Test
  public void ex23() {}

  @Test
  public void ex24() {}

  @Test
  public void ex25() {}

  @Test
  public void ex26() {}

  @Test
  public void ex27() {}

  @Test
  public void ex28() {}

  @Test
  public void ex29() {}

  @Test
  public void ex30() {}

  @Test
  public void ex31() {}

  @Test
  public void ex32() {}

  @Test
  public void ex33() {}

  @Test
  public void ex34() {}

  @Test
  public void ex35() {}
}
