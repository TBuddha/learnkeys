package 委托模式;

/**
 * @author zhout
 * @date 2020/6/16 10:43
 */
class Demo {

  // 对外来说，就像printer类的实例在打印一样
  public static void main(String[] args) {
    Printer printer = new Printer();
    printer.print();
  }
}

class RealPrinter {
  void print() {
    System.out.print("RealPrinter something");
  }
}

class Printer {
  RealPrinter p = new RealPrinter(); // create the delegate

  void print() {
    p.print(); // delegation
  }
}
