package 单例模式.DCL;

import java.io.Serializable;

/**
 * @author zhout
 * @date 2020/9/28 15:58
 * @desc DCL 就是 Double Check Lock 的缩写，即双重检查的同步锁。
 * https://juejin.im/post/6877202342266175496
 */
public class Singleton implements Serializable {

  // 注意，此变量需要用volatile修饰以防止指令重排序
  private static volatile Singleton singleton = null;

  public static Singleton getInstance() {
    // 进入方法内，先判断实例是否为空，以确定是否需要进入同步代码块
    if (singleton == null) {
      synchronized (Singleton.class) {
        // 进入同步代码块时再次判断实例是否为空
        if (singleton == null) {
          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }

  // 防止反射破坏单例
  private Singleton() {
    if (singleton != null) {
      throw new RuntimeException("Can not do this");
    }
  }

  // 定义readResolve方法，防止反序列化返回不同的对象
  private Object readResolve() {
    return singleton;
  }
}
