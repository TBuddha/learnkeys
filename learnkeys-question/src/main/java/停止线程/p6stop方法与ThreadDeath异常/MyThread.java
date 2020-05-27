package 停止线程.p6stop方法与ThreadDeath异常;

/**
 * stop()方法已作废，因为如果强制让线程停止有可能使一些清理性的工作得不到完成。
 * 另外一个情况就是对锁定的对象进行了解锁，导致数据得不到同步的处理，出现数据不一致的问题。
 * @author zhout
 * @date 2020/4/22 10:55
 */
class MyThread extends Thread {

  public void run() {
    super.run();
    try {
      this.stop();
    } catch (ThreadDeath e) {
      System.out.println("进入异常catch");
      e.printStackTrace();
    }
  }
}

class Run {
  public static void main(String[] args) {
    Thread thread = new MyThread();
    thread.start();
  }
}
