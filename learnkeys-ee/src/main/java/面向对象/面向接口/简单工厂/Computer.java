package 面向对象.面向接口.简单工厂;

/**
 * @author zhoutao
 * @date 2019/6/12 16:08
 */
public class Computer {
  private Output output;

  public Computer(Output output) {
    this.output = output;
  }

  // 模拟字符串输入
  public void keyIn(String msg) {
    output.getData(msg);
  }

  // 模拟打印
  public void print() {
    output.out();
  }
}
