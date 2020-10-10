package chapter1_1;

import repo.StdIn;
import repo.StdOut;

import java.util.Scanner;

/**
 * @author zhout
 * @date 2020/9/17 11:08
 */
public class Ex21 {

  // 编写一段程序，从标准输入按行读取数据，其中每行都包含一个名字和两个整数。
  // 然后用 printf()打印一张表格，每行的若干列数据包括名字、两个整数和第一个整数除以第二个整数的结果，
  // 精确到小数点后三位。可以用这种程序将棒球球手的击球命中率或者学生的考试分数制成表格
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("您要输入几个同学的信息？");
    int i = input.nextInt();
    input.nextLine();//过滤\n
    System.out.println("请输入所有同学的信息：");
    String[] str = new String[i];
    for (int j = 0; j < i; j++) {
      str[j] = input.nextLine();
    }
    System.out.println("-------------表格-------------");
    for (int j = 0; j < i; j++) {
      String[] s = str[j].split("\\s+");//  \\s表示 空格,回车,换行等空白符
      // split()方法将一个字符串按照空格分割，结果作为字符串数组返回。
      System.out.printf("姓名：%-10s 成绩1：%-10s 成绩二：%-10s 相除：%-13.3f \n", s[0], s[1], s[2],
              Double.parseDouble(s[1]) / Double.parseDouble(s[2]));
    }
    System.out.println("----------------------------");
  }
}
