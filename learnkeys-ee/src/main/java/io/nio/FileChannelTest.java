package io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author zhouT
 * @date 2018/12/26 19:05
 */
public class FileChannelTest {
  public static void main(String[] args) {
    File f =
        new File(
            "D:\\ideaProject\\YJwork\\SpraceXBootDemo\\web-start\\src\\main\\java内置\\com\\yunjiacloud\\nj\\SpraceXBootDemo\\core\\io\\nio\\FileChannelTest.java内置");

    try {
      // 以文件输入流创建FileChannel
      FileChannel inChannel = new FileInputStream(f).getChannel();
      // 以文件输出流创建FileChannel，用以控制输出
      FileChannel onChannel = new FileOutputStream("a.txt").getChannel();

      // 将FileChannel里的数据全部数据映射成ByteBuffer
      MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
      // 以GBK的字符集创建解码器
      Charset charset = Charset.forName("UTF-8");
      // 直接将buffer的数据全部输出
      onChannel.write(buffer);

      // 再次调用buffer的clear方法，复原limit，position的位置
      buffer.clear();
      // 创建解码器对象
      CharsetDecoder decoder = charset.newDecoder();
      // 使用解码器将ByteBuffer转换成CharBuffer
      CharBuffer charBuffer = decoder.decode(buffer);
      // CharBuffer的toString方法可以获取对应的字符串
      System.out.println(charBuffer.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
