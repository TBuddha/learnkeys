package io.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author zhouT(zhoutao @ yunjiacloud.com)
 * @date 2018/12/27 14:49
 */
public class FileLockTest {
  public static void main(String[] args) throws Exception {
      FileChannel channel = new FileOutputStream("a.txt").getChannel();
      //使用非阻塞式方式对指定文件加锁
      FileLock lock = channel.tryLock();
      //程序暂停10s
      Thread.sleep(10000);
      lock.release();
  }
}
