package com.zhout.停止线程.p8使用return停止线程;

/**
 * 将方法interrupt()与return结合使用也能实现停止线程的效果
 * 不过还是建议使用“抛异常”的方法来实现线程的停止，因为在catch块中还可以将异常向上抛，使线程停止事件得以传播
 * @author zhout
 * @date 2020/4/22 11:02
 */
public class MyThread extends Thread {
  public void run() {
    while (true) {
      if (this.isInterrupted()) {
        System.out.println("线程被停止了！");
        return;
      }
      System.out.println("Time: " + System.currentTimeMillis());
    }
  }
}

class Run {
  public static void main(String args[]) throws InterruptedException {
    Thread thread = new MyThread();
    thread.start();
    Thread.sleep(2000);
    thread.interrupt();
  }
}
