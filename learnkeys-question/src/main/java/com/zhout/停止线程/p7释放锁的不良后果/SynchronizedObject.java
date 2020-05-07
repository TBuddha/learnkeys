package com.zhout.停止线程.p7释放锁的不良后果;

import lombok.Data;

/**
 * 使用stop()释放锁将会给数据造成不一致性的结果。如果出现这样的情况，
 * 程序处理的数据就有可能遭到破坏，最终导致程序执行的流程错误，一定要特别注意：
 * @author zhout
 * @date 2020/4/22 10:58
 */
@Data
class SynchronizedObject {
  private String name = "a";
  private String password = "aa";

  public synchronized void printString(String name, String password) {
    try {
      this.name = name;
      Thread.sleep(100000);
      this.password = password;
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class MyThread extends Thread {
  private SynchronizedObject synchronizedObject;

  public MyThread(SynchronizedObject synchronizedObject) {
    this.synchronizedObject = synchronizedObject;
  }

  public void run() {
    synchronizedObject.printString("b", "bb");
  }
}

class Run {
  public static void main(String[] args) throws InterruptedException {
    SynchronizedObject synchronizedObject = new SynchronizedObject();
    Thread thread = new MyThread(synchronizedObject);
    thread.start();
    Thread.sleep(500);
    thread.stop();
    System.out.println(synchronizedObject.getName() + "  " + synchronizedObject.getPassword());
  }
}
