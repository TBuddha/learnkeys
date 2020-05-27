package 面向对象.面向接口.命令模式;

/**
 * @author zhoutao
 * @date 2019/6/12 16:33
 */
public class AddCommand implements Command {
  @Override
  public void process(int[] target) {
    int sum = 0;
    for (int tmp : target) {
      sum += tmp;
    }
    System.out.println("数组元素的总和是:" + sum);
  }
}
