package chapter1_1;

import org.junit.Test;

import java.util.Locale;

/**
 * @author zhout
 * @date 2020/9/16 16:53
 */
public class Ex11 {
  // “编写一段代码，打印出一个二维布尔数组的内容。其中，使用 * 表示真，空格表示假。打印出行号和列号。”
  @Test
  public void test() {
    boolean[][] boo =
        new boolean[][] {{true, false, false}, {true, true, true}, {true, true, false}};
    printBooleanMatrix(boo);
    printout(boo);
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

  private static void printout(boolean[][] a1){
    for (int i = 0; i < a1.length; i++) {
      for (int j = 0; j < a1[i].length; j++) {
        if (a1[i][j]){
          System.out.println(String.format(Locale.CHINA,"%d  %d *",i+1,j+1));
        } else {
          System.out.println(String.format(Locale.CHINA,"%d  %d /",i+1,j+1));
        }
      }
    }
  }
}
