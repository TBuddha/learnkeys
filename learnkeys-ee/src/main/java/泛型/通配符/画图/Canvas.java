package 泛型.通配符.画图;

import java.util.List;

/**
 * @author zhouT
 * @date 2019/3/8 17:56
 */
public class Canvas {

  public void drawAll(List<? extends Shape> shapes) {
    for (Object obj : shapes) {
      Shape s = (Shape) obj;
      s.draw(this);
    }
  }
}
