package 停止线程.p3能停止的线程_异常法;

/**
 * @author zhout
 * @date 2020/4/22 10:21
 * 如何解决语句继续运行的问题呢
 */
class MyThread3 extends Thread {
  public void run() {
    super.run();
    try {
      // !!!这里我调整了原始例子中的50万变成500万，否则无法成功，猜测与计算机性能有关
      for (int i = 0; i < 5000000; i++) {
        if (this.interrupted()) {
          System.out.println("线程已经终止， for循环不再执行");
          throw new InterruptedException();
        }
        System.out.println("i=" + (i + 1));
      }

      System.out.println("这是for循环外面的语句，也会被执行");
    } catch (InterruptedException e) {
      System.out.println("进入MyThread.java类中的catch了。。。");
      e.printStackTrace();
    }
  }
}

class Run3 {
  public static void main(String[] args) {
    Thread thread = new MyThread3();
    thread.start();
    try {
      Thread.sleep(2000);
      thread.interrupt();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
