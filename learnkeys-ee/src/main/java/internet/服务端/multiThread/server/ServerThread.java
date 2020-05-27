package internet.服务端.multiThread.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author zhouT
 * @date 2019/构建器/22 18:11
 */
// 负责处理每个线程通信的线程类
public class ServerThread implements Runnable {
  // 定义当前线程所处理的Socket
  Socket socket = null;
  // 该线程所处理的Socket所对应的输入流
  BufferedReader br = null;

  public ServerThread(Socket socket) throws IOException {
    this.socket = socket;
    // 初始化该Socket对应的输入流
    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  @Override
  public void run() {
    try {
      String content = null;
      // 采用循环不断从Socket中读取客户端发送过来的数据
      while ((content = readFromClient()) != null) {
        // 遍历socketList中的每个Socket，
        // 将读到的内容向每个Socket发送一次
        for (Socket socket : MyServer.socketList) {
          PrintStream ps = new PrintStream(socket.getOutputStream());
          ps.println(content);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 定义读取客户端数据的方法
  private String readFromClient() {
    try {
      return br.readLine();
    }
    // 如果捕捉到异常，表明该Socket对应的客户端已经关闭
    catch (IOException e) {
      // 删除该Socket。
      MyServer.socketList.remove(socket);
    }
    return null;
  }
}
