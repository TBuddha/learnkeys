package thread.生命周期;

import static java.lang.Thread.sleep;

/**
 * @author zhouT
 * @date 2018/12/28 10:46
 */
public class SecondThread implements Runnable {
  private int i;
  // run()方法同样是线程执行体
  @Override
  public void run() {
    for (; i < 10; i++) {
      // 当实现runnable接口时，如果想获取当前线程
      // 只能用Thread.currentThread()方法
      System.out.println(Thread.currentThread().getName() + " " + i);
      try {
        sleep(1000); // 休眠1秒，避免太快导致看不到同时执行
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      if (i == 5) {
        SecondThread st = new SecondThread();
        // 通过new Thread(Runnable target, String name)方法创建新线程
        new Thread(st, "新线程1").start();
        new Thread(st, "新线程2").start();
      }
      try {
        sleep(1000); // 休眠1秒，避免太快导致看不到同时执行
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
