package thread.线程同步.testLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhouT
 * @date 2019/构建器/9 17:24
 */
class X {
  // 定义锁对象
  private ReentrantLock lock = new ReentrantLock();

  // 定义需要保证线程安全的方法
  public void m() {
    // 加锁
    lock.lock();
    try {
      // 需要保证线程安全的代码
    } finally {
      lock.unlock();
    }
  }
}
