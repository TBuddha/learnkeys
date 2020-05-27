package thread.控制线程通信.线程组和未处理异常;

/**
 * @author zhouT
 * @date 2019/构建器/11 20:42
 */
class MyThread extends Thread {

  public MyThread(String name) {
    super(name);
  }

  public MyThread(ThreadGroup group, String name) {
    super(group, name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      System.out.println(getName() + "线程i的变量" + i);
    }
  }
}

public class ThreadGroupTest {

  public static void main(String[] args) {
    // 获取主线程所在的线程组，这是所有线程默认的线程组
    ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
    System.out.println("主线程的名字" + mainGroup.getName());
    System.out.println("主线程是否是后台线程：" + mainGroup.isDaemon());
    new MyThread("主线程组的线程").start();

    ThreadGroup tg = new ThreadGroup("新线程组");
    tg.setDaemon(true);
    System.out.println("tg线程是否是后台线程：" + tg.isDaemon());

    MyThread mt = new MyThread(tg, "tg组的线程甲");
    mt.start();
    new MyThread(tg, "tg组的线程乙").start();
  }
}
