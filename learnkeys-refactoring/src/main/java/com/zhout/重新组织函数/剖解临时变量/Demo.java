package com.zhout.重新组织函数.剖解临时变量;

/**
 * @author zhout
 * @date 2020/4/13 16:47
 */
public class Demo {

  double _height = 1;
  double _width = 2;

  public void foo1() {
    double temp = 2 * (_height + _width);
    System.out.println(temp);
    temp = _height * _width;
    System.out.println(temp);
  }

  public void foo2() {
    final double perimeter = 2 * (_height + _width);
    System.out.println(perimeter);
    final double area = _height * _width;
    System.out.println(area);
  }

  public static void main(String[] args) {
    Demo demo = new Demo();
    demo.foo2();
  }
}
