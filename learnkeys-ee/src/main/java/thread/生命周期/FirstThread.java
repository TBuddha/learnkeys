package thread.生命周期;

/**
 * @author zhouT
 * @date 2018/12/27 17:49
 */
class FirstThread extends Thread {
  // 通过继承thread类来创建线程类
  private int i;

  // 重写run方法，run方法的方法体就是线程执行体
  @Override
  public void run() {
    for (; i < 10; i++) {
      // 当线程类继承thread类时，直接使用this即可获取当前线程
      // Thread对象的getName()返回当前线程的的名字
      // 因此可以直接调用getName()方法返回当前线程的名字
      System.out.println(getName() + " " + i);
      try {
        sleep(1000); // 休眠1秒，避免太快导致看不到同时执行
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      // 获取当前线程
      System.out.println(Thread.currentThread().getName() + " " + i);
      if (i == 5) {
        // 创建并启动第一个线程
        new FirstThread().start();
        // 第二个
        new FirstThread().start();
      }
      try {
        sleep(1000); // 休眠1秒，避免太快导致看不到同时执行
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
