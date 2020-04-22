package com.zhout.停止线程.p5暴力停止;

/**
 * @author zhout
 * @date 2020/4/22 10:50
 */
public class MyThread extends Thread {
  private int i = 0;

  public void run() {
    super.run();
    try {
      while (true) {
        System.out.println("i=" + i);
        i++;
        Thread.sleep(200);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Run {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new MyThread();
    thread.start();
    Thread.sleep(2000);
    thread.stop();
  }
}
