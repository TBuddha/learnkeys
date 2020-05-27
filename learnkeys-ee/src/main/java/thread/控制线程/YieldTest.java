package thread.控制线程;

/**
 * @author zhouT
 * @date 2019/构建器/9 11:28
 */
public class YieldTest extends Thread {
  public YieldTest(String name) {
    super(name);
  }

  // 定义run方法为线程执行体
  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      System.out.println(getName() + " " + i);
      // 当i等于20时，使用yield()方法让当前线程让步
      if (i == 20) {
        Thread.yield();
      }
      /* 由于多cpu并行，注释优先级的情况，需要睡眠才能看到效果
      try {
          sleep(构建器);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }*/
    }
  }

  public static void main(String[] args) {
    // 启动两个并发线程
    YieldTest yt1 = new YieldTest("高级");
    // 将yt1线程设置为最高优先级
    yt1.setPriority(Thread.MAX_PRIORITY);
    yt1.start();

    // 将yt2线程设置为最低优先级
    YieldTest yt2 = new YieldTest("低级");
    yt2.setPriority(Thread.MIN_PRIORITY);
    yt2.start();
  }
}
