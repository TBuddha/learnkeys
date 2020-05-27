package thread.控制线程;

/**
 * @author zhouT
 * @date 2019/构建器/7 14:40
 */
public class DaemonThread extends Thread {

  @Override
  public void run() {
    // 定义后台线程的线程执行体与普通线程没有任何区别
    for (int i = 0; i < 1000; i++) {
      System.out.println(getName() + " " + i);
    }
  }

  public static void main(String[] args) {
    DaemonThread thread = new DaemonThread();
    // 将此线程设置成后台线程
    thread.setDaemon(true);
    // 启动后台线程
    thread.start();
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }
    // -----程序执行到此处，前台线程(main线程)结束-------
    // 后台线程也应该随之结束
  }
}
