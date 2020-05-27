package thread.控制线程;

/**
 * @author zhouT
 * @date 2019/构建器/4 17:55
 */
class JoinThread extends Thread {

  public JoinThread(String name) {
    // 用于设置该线程的名字
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(getName() + " " + i);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    // 启动子线程
    new JoinThread("新线程").start();
    for (int i = 0; i < 100; i++) {
      if (i == 20) {
        JoinThread jt = new JoinThread("被Join的线程");
        jt.start();
        // main线程调用了jt线程的join()方法，main线程必须
        // 等jt线程执行结束才会向下执行
        jt.join();
        System.out.println(Thread.currentThread().getName() + " " + i);
      }
    }
  }
}
