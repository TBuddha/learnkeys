package annotation.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/6/21 10:32
 */
@SuppressWarnings(value = "unchecked") // 关闭整个类里的编译器警告
public class SuppressWarningsTest {
  public static void main(String[] args) {
    List<String> list = new ArrayList();
    List[] lists = new List[0];
  }
}
