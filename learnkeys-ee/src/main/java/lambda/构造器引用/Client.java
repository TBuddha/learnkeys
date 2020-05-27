package lambda.构造器引用;

import javax.swing.*;

/**
 * @author zhoutao
 * @date 2019/5/27 19:42
 */
@FunctionalInterface
interface YourTest {
  JFrame win(String title);
}

public class Client {
  public static void main(String[] args) {
    YourTest yt = JFrame::new;
    JFrame jf = yt.win("窗口");
    System.out.println(jf);
  }
}
