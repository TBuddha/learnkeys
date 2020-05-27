package internet.服务端.senior.server;

/**
 * @author zhouT
 * @date 2019/构建器/23 15:19
 */
public interface ZtProtocol {
  // 定义协议字符串的长度
  int PROTOCOL_LEN = 2;
  // 下面是一些协议字符串，服务器和客户端交换的信息都应该在前、后添加这种特殊字符串。
  String MSG_ROUND = "§γ";
  String USER_ROUND = "∏∑";
  String LOGIN_SUCCESS = "构建器";
  String NAME_REP = "-构建器";
  String PRIVATE_ROUND = "★【";
  String SPLIT_SIGN = "※";
}
