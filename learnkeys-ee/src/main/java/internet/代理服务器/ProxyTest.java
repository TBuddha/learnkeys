package internet.代理服务器;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @author zhouT
 * @date 2019/3/7 15:24
 */
public class ProxyTest {

  // 下面是代理服务器的地址和端口，
  // 换成实际有效的代理服务器的地址和端口
  final String PROXY_ADDR = "172.16.5.241";
  final int PROXY_PORT = 50374;
  // 下面是你试图打开的网站地址
  String urlStr = "https://www.baidu.com";

  public void init() throws IOException {
    URL url = new URL(urlStr);
    // 创建一个代理服务器对象
    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
    // 使用指定的代理服务器打开连接
    URLConnection conn = url.openConnection(proxy);
    // 设置超时时长。
    conn.setConnectTimeout(5000);

    try (
    // 通过代理服务器读取数据的Scanner
    Scanner scan = new Scanner(conn.getInputStream());
        // 初始化输出流
        PrintStream ps = new PrintStream("index.htm"); ) {
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        // 在控制台输出网页资源内容
        System.out.println(line);
        // 将网页资源内容输出到指定输出流
        ps.println(line);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    new ProxyTest().init();
  }
}
