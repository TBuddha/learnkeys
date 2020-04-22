package com.zhout.停止线程.p4在沉睡中停止;

/**
 * @author zhout
 * @date 2020/4/22 10:43
 *  先interrupt()然后再用sleep停止
 */
public class MyThread2 extends Thread {
  public void run() {
    super.run();
    try {
      System.out.println("线程开始。。。");
      for (int i = 0; i < 10000; i++) {
        System.out.println("i=" + i);
      }
      Thread.sleep(200000);
      System.out.println("线程结束。");
    } catch (InterruptedException e) {
      System.out.println("先停止，再遇到sleep，进入catch异常");
      e.printStackTrace();
    }
  }
}

class Run {
  public static void main(String[] args) {
    Thread thread = new MyThread2();
    thread.start();
    thread.interrupt();
  }
}
