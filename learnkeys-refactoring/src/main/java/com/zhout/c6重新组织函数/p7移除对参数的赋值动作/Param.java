package com.zhout.c6重新组织函数.p7移除对参数的赋值动作;

/**
 * @author zhout
 * @date 2020/4/14 14:55
 */
public class Param {

  /**
   * java使用"pass by value"「函数调用」方式，这常常造成许多人迷惑。在所有地点，Java都严格釆用pass by value
   * 所以下列程序会产生这样的输出：
   * arg in triple:15
   * x after triple: 5
   */
  public static void main(String[] args) {
    int x = 5;
    triple(x);
    System.out.println("x after triple: " + x);
  }

  private static void triple(int arg) {
    arg = arg * 3;
    System.out.println("arg in triple: " + arg);
  }
}
