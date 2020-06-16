package 委托模式.service;

/**
 * @author zhout
 * @date 2020/6/16 10:46
 */
class LoginService implements BusinessService {
  public void doService() {
    System.out.println("处理登录相关业务");
  }
}
