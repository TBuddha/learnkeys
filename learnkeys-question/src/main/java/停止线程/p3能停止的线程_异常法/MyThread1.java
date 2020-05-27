package 停止线程.p3能停止的线程_异常法;

/**
 * @author zhout
 * @date 2020/4/22 10:06
 */
class MyThread1 extends Thread {
  public void run() {
    super.run();
    for (int i = 0; i < 500000; i++) {
      if (this.interrupted()) {
        System.out.println("线程已经终止， for循环不再执行");
        break;
      }
      System.out.println("i=" + (i + 1));
    }
  }
}

class Run1 {
  public static void main(String[] arg) {
    Thread thread = new MyThread1();
    thread.start();
    try {
      Thread.sleep(2000);
      thread.interrupt();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
