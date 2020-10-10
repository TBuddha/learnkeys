package chapter1_1;

/**
 * @author zhout
 * @date 2020/9/29 18:26
 */
public class Ex17 {
  // 找出以下递归函数的问题:
  // public static String exR2(int n) {
  //    String s = exR2(n - 3) + n + exR2(n - 2) + n;
  //    if (n <= 0)
  //        return "";
  //    return s;
  // }
  // 解：这段代码中的基础情况永远不会被访问。
  // 调用 exR2(3) 会产生调用 exR2(0)、exR2(-3) 和exR2(-6)，循环往复直到发生 StackOverflowError。
}
