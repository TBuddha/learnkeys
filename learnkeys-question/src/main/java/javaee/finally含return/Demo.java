package javaee.finally含return;

/**
 * @author zhout
 * @date 2020/5/27 15:35
 */
class Demo {

  // 注意：当try语句和finally语句中都有return语句时，
  // 在方法返回之前，finally 语句的内容将被执行，并且finally语句的返回值将会覆盖原始的返回值
  public static int f(int value) {
    try {
      return value * value;
    } finally {
      if (value == 2) {
        return 0;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("f = " + f(2));//f = 0
  }
}
