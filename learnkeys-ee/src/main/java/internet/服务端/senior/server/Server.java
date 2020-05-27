package internet.服务端.senior.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhouT
 * @date 2019/构建器/23 15:45
 */
public class Server {
  private static final int SERVER_PORT = 30000;
  // 使用MyMap对象来保存每个客户名字和对应输出流之间的对应关系。
  public static ZtMap<String, PrintStream> clients = new ZtMap<>();

  public void init() {
    try {
      // 建立监听的ServerSocket
      ServerSocket ss = new ServerSocket(SERVER_PORT);
      // 采用死循环来不断接受来自客户端的请求
      while (true) {
        Socket socket = ss.accept();
        new ServerThread(socket).start();
      }
      // 如果抛出异常
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("服务器启动失败，是否端口" + SERVER_PORT + "已被占用");
    }
  }

  public static void main(String[] args) {
    Server server = new Server();
    server.init();
  }
}
