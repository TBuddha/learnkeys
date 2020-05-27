package internet.服务端.senior.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author zhouT
 * @date 2019/构建器/23 15:50
 */
public class ServerThread extends Thread {
  private Socket socket;
  BufferedReader br = null;
  PrintStream ps = null;

  // 定义一个构造器，用于接收一个Socket来创建ServerThread线程
  public ServerThread(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      // 获取该Socket对应的输入流
      br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // 获取该Socket对应的输出流
      ps = new PrintStream(socket.getOutputStream());
      String line = null;
      while ((line = br.readLine()) != null) {
        // 如果读到的行以ZtProtocol.USER_ROUND开始，并以其结束，
        // 可以确定读到的是用户登陆的用户名
        if (line.startsWith(ZtProtocol.USER_ROUND) && line.endsWith(ZtProtocol.USER_ROUND)) {
          // 得到真实消息
          String userName = getRealMsg(line);
          // 如果用户名重复
          if (Server.clients.map.containsKey(userName)) {
            System.out.println("重复");
            ps.println(ZtProtocol.NAME_REP);
          } else {
            System.out.println("成功");
            ps.println(ZtProtocol.LOGIN_SUCCESS);
            Server.clients.put(userName, ps);
          }
        }
        // 如果读到的行以ZtProtocol.PRIVATE_ROUND开始，并以其结束，
        // 可以确定是私聊信息，私聊信息只向特定的输出流发送
        else if (line.startsWith(ZtProtocol.PRIVATE_ROUND)
            && line.endsWith(ZtProtocol.PRIVATE_ROUND)) {
          // 得到真实消息
          String userAndMsg = getRealMsg(line);
          // 以SPLIT_SIGN来分割字符串，前面部分是私聊用户，后面部分是聊天信息
          String user = userAndMsg.split(ZtProtocol.SPLIT_SIGN)[0];
          String msg = userAndMsg.split(ZtProtocol.SPLIT_SIGN)[1];
          // 获取私聊用户对应的输出流，并发送私聊信息
          Server.clients.map.get(user).println(Server.clients.getKeyByValue(ps) + "悄悄地对你说：" + msg);
        }
        // 公聊要向每个Socket发送
        else {
          // 得到真实消息
          String msg = getRealMsg(line);
          // 遍历clients中的每个输出流
          for (PrintStream clientPs : Server.clients.valueSet()) {
            clientPs.println(Server.clients.getKeyByValue(ps) + "说：" + msg);
          }
        }
      }
    }
    // 捕捉到异常后，表明该Socket对应的客户端已经出现了问题
    // 所以程序将其对应的输出流从Map中删除
    catch (IOException e) {
      Server.clients.removeByValue(ps);
      System.out.println(Server.clients.map.size());
      // 关闭网络、IO资源
      try {
        if (br != null) {
          br.close();
        }
        if (ps != null) {
          ps.close();
        }
        if (socket != null) {
          socket.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  // 将读到的内容去掉前后的协议字符，恢复成真实数据
  private static String getRealMsg(String line) {
    return line.substring(ZtProtocol.PROTOCOL_LEN, line.length() - ZtProtocol.PROTOCOL_LEN);
  }
}
