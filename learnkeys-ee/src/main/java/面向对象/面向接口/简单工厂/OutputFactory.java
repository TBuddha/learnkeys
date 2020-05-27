package 面向对象.面向接口.简单工厂;

/**
 * @author zhoutao
 * @date 2019/6/12 16:15
 */
public class OutputFactory {
  public Output getOutput() {
    // 下面两行代码用于控制系统到底使用Output的哪个实现类
    return new Printer();
    // return new BetterPrinter();
  }

  public static void main(String[] args) {
    OutputFactory of = new OutputFactory();
    Computer c = new Computer(of.getOutput());
    c.keyIn("应用实战");
    c.keyIn("权威指南");
    c.print();
  }
}
