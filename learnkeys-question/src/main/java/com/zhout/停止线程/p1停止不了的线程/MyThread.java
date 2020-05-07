package com.zhout.停止线程.p1停止不了的线程;

/**
 * @author zhout
 * @date 2020/4/22 09:38
 */
class MyThread extends Thread {
  public void run() {
    super.run();
    for (int i = 0; i < 500000; i++) {
      System.out.println("i=" + (i + 1));
    }
  }
}

class Run {
  /** interrupt()方法的使用效果并不像for+break语句那样，马上就停止循环。
   * 调用interrupt方法是在当前线程中打了一个停止标志，并不是真的停止线程。
   */
  public static void main(String[] args) {
    Thread thread = new MyThread();
    thread.start();
    try {
      Thread.sleep(2000);
      thread.interrupt();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
