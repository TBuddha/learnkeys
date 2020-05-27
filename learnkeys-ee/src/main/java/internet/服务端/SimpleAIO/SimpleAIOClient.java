package internet.服务端.SimpleAIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

public class SimpleAIOClient {
  static final int PORT = 30000;

  public static void main(String[] args) throws Exception {
    ByteBuffer buff = ByteBuffer.allocate(1024);
    Charset uft = Charset.forName("UTF-8");
    try (AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open()) {
      // 连接到远程服务器
      clientChannel.connect(new InetSocketAddress("127.0.0.构建器", PORT)).get();
      buff.clear();
      // 从buff中读取数据
      clientChannel.read(buff).get();
      buff.flip();
      // 将buff中的内容转换为字符串
      String content = uft.decode(buff).toString();
      System.out.println("服务器信息：" + content);
    }
  }
}
