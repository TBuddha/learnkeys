package 面向对象.面向接口.命令模式;

/**
 * @author zhoutao
 * @date 2019/5/27 10:39
 */
public interface Command {
  // 接口里定义的process方法用于封装“处理行为”
  void process(int[] target);
}
