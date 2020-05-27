package 泛型.通配符.画图;

/**
 * @author zhouT
 * @date 2019/3/8 17:49
 */
public class Circle extends Shape {
  @Override
  public void draw(Canvas canvas) {
    System.out.println("在画布" + canvas + "上画个圆");
  }
}
