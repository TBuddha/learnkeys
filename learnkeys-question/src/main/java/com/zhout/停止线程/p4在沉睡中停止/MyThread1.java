package com.zhout.停止线程.p4在沉睡中停止;

/**
 * @author zhout
 * @date 2020/4/22 10:40
 *     <p>如果线程在sleep()状态下停止线程，会是什么效果呢？
 */
class MyThread1 extends Thread {
  public void run() {
    super.run();
    try {
      System.out.println("线程开始。。。");
      Thread.sleep(200000);
      System.out.println("线程结束。");
    } catch (InterruptedException e) {
      System.out.println("在沉睡中被停止, 进入catch， 调用isInterrupted()方法的结果是：" + this.isInterrupted());
      e.printStackTrace();
    }
  }
}

class Run1 {

  /** 从打印的结果来看， 如果在sleep状态下停止某一线程，会进入catch语句，并且清除停止状态值，使之变为false。 */
  public static void main(String[] args) {
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
