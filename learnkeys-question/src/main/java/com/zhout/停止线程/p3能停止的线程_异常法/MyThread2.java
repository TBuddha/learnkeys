package com.zhout.停止线程.p3能停止的线程_异常法;

/**
 * @author zhout
 * @date 2020/4/22 10:16
 *     <p>MyThread1的示例虽然停止了线程，但如果for语句下面还有语句，还是会继续运行的。看下面的例子：
 */
public class MyThread2 extends Thread {
  public void run() {
    super.run();
    // !!!这里我调整了原始例子中的50万变成500万，否则无法成功，猜测与计算机性能有关
    for (int i = 0; i < 5000000; i++) {
      if (this.interrupted()) {
        System.out.println("线程已经终止， for循环不再执行");
        break;
      }
      System.out.println("i=" + (i + 1));
    }

    System.out.println("这是for循环外面的语句，也会被执行");
  }
}

class Run2 {
  public static void main(String[] args) {
    Thread thread = new MyThread2();
    thread.start();
    try {
      Thread.sleep(2000);
      thread.interrupt();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
