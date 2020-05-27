package 停止线程.p2判断线程是否停止状态;

/**
 * @author zhout
 * @date 2020/4/22 09:49
 */
class MyThread extends Thread {
  public void run() {
    super.run();
    for (int i = 0; i < 500000; i++) {
      i++;
      // System.out.println("i="+(i+1));
    }
  }
}

class Run {

  /**
   * 从控制台打印的结果来看，线程并未停止，这也证明了interrupted()方法的解释，测试当前线程是否已经中断。
   * 这个当前线程是main，它从未中断过，所以打印的结果是两个false.
   */
  public static void main(String[] args) {
    Thread thread = new MyThread();
    thread.start();
    try {
      Thread.sleep(2000);
      thread.interrupt();

      System.out.println("stop 1??" + thread.interrupted());
      System.out.println("stop 2??" + thread.interrupted());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

// 如何使main线程产生中断效果
class Run2 {

  /**
   * 方法interrupted()的确判断出当前线程是否是停止状态。但为什么stop 2是false呢？
   * 官方帮助文档中对interrupted方法的解释：测试当前线程是否已经中断。线程的中断状态由该方法清除。
   * 换句话说，如果连续两次调用该方法，则第二次调用返回false。
   */
  public static void main(String[] args) {
    Thread.currentThread().interrupt();
    System.out.println("stop 1??" + Thread.interrupted());
    System.out.println("stop 2??" + Thread.interrupted());

    System.out.println("End");
  }
}

// isInterrupted方法
class Run3 {
  public static void main(String[] args) {
    Thread thread = new MyThread();
    thread.start();
    thread.interrupt();

    // isInterrupted()并为清除状态，所以打印了两个true。
    System.out.println("stop 1??" + thread.isInterrupted());
    System.out.println("stop 2??" + thread.isInterrupted());
  }
}
