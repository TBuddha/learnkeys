package 面向对象.面向接口.简单工厂;

/**
 * @author zhoutao
 * @date 2019/6/12 16:11
 */
public interface Output {
  // 接口里定义的属性只能是常量
  int MAX_CACHE_LINE = 50;

  // 接口里定义的只能是public的抽象实例方法
  void out();

  void getData(String msg);
}
