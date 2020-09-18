package chapter1_1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/9/16 16:54
 */
public class Ex13 {
  // “编写一段代码，打印出一个  行  列的二维数组的转置 （交换行和列）”
  @Test
  public void test() {
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
}
