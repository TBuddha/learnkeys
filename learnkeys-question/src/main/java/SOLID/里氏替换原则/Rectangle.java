package SOLID.里氏替换原则;

/**
 * 破坏业务正确性的例子,最典型的例子就是Bob大叔在《敏捷软件开发：原则、模式与实践》中讲到的正方形继承矩形的例子了。
 * 从一般意义来看，正方形是一种矩形，但这种继承关系破坏了业务的正确性。
 *
 * @author zhout
 * @date 2020/5/21 09:47
 */
class Rectangle {
  double width;
  double height;

  public double area() {
    return width * height;
  }

  public static void main(String[] args) {
    Rectangle r = new Square();
    r.width = 5;
    r.height = 4;
    assert (r.area() == 20); // ! 如果r是一个正方形，则面积为16
  }
}

class Square extends Rectangle {
  public void setWidth(double width) {
    this.width = width;
    this.height = width;
  }

  public void setHeight(double height) {
    this.height = width;
    this.width = width;
  }
}
