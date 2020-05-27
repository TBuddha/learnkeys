package lambda.基础;

/**
 * @author zhoutao
 * @date 2019/5/27 18:01
 */
public class Client {
  public static void main(String[] args) {
    Runnable r =
        () -> {
          for (int i = 0; i < 100; i++) {
            System.out.println();
          }
        };

    // 编译错误
    /*Object obj = () -> {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    };*/

    Object obj =
        (Runnable)
            () -> {
              for (int i = 0; i < 100; i++) {
                System.out.println();
              }
            };

    Object obj1 =
        (FkTest)
            () -> {
              for (int i = 0; i < 100; i++) {
                System.out.println();
              }
            };
  }
}
