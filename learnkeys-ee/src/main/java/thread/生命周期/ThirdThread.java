package thread.生命周期;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhouT
 * @date 2018/12/28 14:41
 */
public class ThirdThread {
  public static void main(String[] args) {
    // 创建Callable对象
    ThirdThread rt = new ThirdThread();
    // 先使用lambda表达式创建Callable<Integer>对象
    // 使用FutureTask来包装Callable对象
    FutureTask<Integer> task =
        new FutureTask<>(
            (Callable<Integer>)
                () -> {
                  int i = 0;
                  for (; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                  }
                  // call()方法可以有返回值
                  return i;
                });

    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      if (i == 20) {
        // 实质还是以Callable对象来创建并启动线程的
        new Thread(task, "有返回值的线程").start();
      }
    }
    // 获取线程返回值
    try {
      System.out.println("子线程的返回值:" + task.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
