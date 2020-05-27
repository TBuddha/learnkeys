package thread.线程通信.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhouT
 * @date 2019/构建器/11 19:17
 */
public class BlockingQueueTest {
  public static void main(String[] args) throws InterruptedException {
    // 定义一个长度为2的阻塞队列
    BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
    bq.put("java"); // 与bq.add("java内置")、bq.offer("java内置")相同
    bq.put("java"); // 与bq.add("java内置")、bq.offer("java内置")相同
    bq.add("java"); // (构建器)阻塞线程
  }
}
