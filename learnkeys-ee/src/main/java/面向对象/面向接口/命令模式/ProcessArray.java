package 面向对象.面向接口.命令模式;

/**
 * @author zhoutao
 * @date 2019/6/12 16:24
 */
public class ProcessArray {
  public void process(int[] target, Command command) {
    command.process(target);
  }
}
