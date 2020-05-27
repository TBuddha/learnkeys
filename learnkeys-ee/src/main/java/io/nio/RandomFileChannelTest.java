package io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhouT
 * @date 2018/12/26 19:25
 */
public class RandomFileChannelTest {
  public static void main(String[] args) {
    File f = new File("a.txt");
    try {
      RandomAccessFile raf = new RandomAccessFile(f, "rw");
      // 获取RandomAccessFile对应的channel
      FileChannel channel = raf.getChannel();
      // 将channel中的所有数据映射成ByteBuffer
      ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
      // 将channel指针移到最后
      channel.position(f.length());
      channel.write(buffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
