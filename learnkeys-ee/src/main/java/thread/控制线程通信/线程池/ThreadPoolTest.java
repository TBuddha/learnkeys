package thread.控制线程通信.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouT
 * @date 2019/构建器/14 19:22
 */
class ThreadPoolTest {
  public static void main(String[] args) {
    // 创建一个具有固定线程数的(6)的线程池
    ExecutorService pool = Executors.newFixedThreadPool(6);
    Runnable target =
        () -> {
          for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "的i值为" + i);
          }
        };
    // 向线程池中提交两个线程
    pool.submit(target);
    pool.submit(target);
    // 关闭线程
    pool.shutdown();
  }
}
