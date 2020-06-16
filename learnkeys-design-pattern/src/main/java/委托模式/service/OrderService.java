package 委托模式.service;

/**
 * @author zhout
 * @date 2020/6/16 10:47
 */
class OrderService implements BusinessService {
  public void doService() {
    System.out.println("订单业务模块");
  }
}
