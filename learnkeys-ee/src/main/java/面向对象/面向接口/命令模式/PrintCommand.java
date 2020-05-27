package 面向对象.面向接口.命令模式;

/**
 * @author zhoutao
 * @date 2019/6/12 16:32
 */
public class PrintCommand implements Command {
  @Override
  public void process(int[] target) {
    for (int tmp : target) {
      System.out.println("迭代输出目标数组的元素:" + tmp);
    }
  }
}
