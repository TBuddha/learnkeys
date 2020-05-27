package internet.服务端.halfClose;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhouT
 * @date 2019/构建器/23 17:40
 */
public class Client {
  public static void main(String[] args) throws IOException {
    Socket s = new Socket("localhost", 30000);
    Scanner scan = new Scanner(s.getInputStream());
    if (scan.hasNextLine()) {
      System.out.println(scan.nextLine());
    }
    PrintStream ps = new PrintStream(s.getOutputStream());
    ps.println("客户端的第一行数据");
    ps.println("客户端的第二行数据");
    ps.close();
    scan.close();
    s.close();
  }
}
