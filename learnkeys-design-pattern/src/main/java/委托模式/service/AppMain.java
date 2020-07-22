package 委托模式.service;

/**
 * @author zhout
 * @date 2020/6/16 10:52
 */
class AppMain {
  public static void main(String[] args) {
    BusinessDelegate businessDelegate = new BusinessDelegate();
    BusinessLookup businessLookup = new BusinessLookup();
    businessLookup.setLoginService(new LoginService());
    businessLookup.setOrderService(new OrderService());

    businessDelegate.setBusinessLookup(businessLookup);
    businessDelegate.setServerType(ServerType.LOGIN);
    Client client = new Client(businessDelegate);
    client.doTask();

    //    businessDelegate.setServerType(ServerType.ORDER);
    //    client.doTask();
  }
}
