package 泛型.通配符.画图;

/**
 * @author zhouT
 * @date 2019/3/8 17:51
 */
public class Rectangle extends Shape {
  @Override
  public void draw(Canvas canvas) {
    System.out.println("把矩形画在画布" + canvas + "上");
  }
}
