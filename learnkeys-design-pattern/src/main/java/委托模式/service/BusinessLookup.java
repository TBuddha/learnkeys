package 委托模式.service;

/**
 * @author zhout
 * @date 2020/6/16 10:48
 */
class BusinessLookup {

  private OrderService orderService;

  private LoginService loginService;

  /**
   * 查找对应的服务
   *
   * @param serverType
   * @return
   */
  public BusinessService getBusinessService(ServerType serverType) {
    if (serverType.equals(ServerType.LOGIN)) {
      return loginService;
    } else {
      return orderService;
    }
  }

  public void setOrderService(OrderService orderService) {
    this.orderService = orderService;
  }

  public void setLoginService(LoginService loginService) {
    this.loginService = loginService;
  }
}
