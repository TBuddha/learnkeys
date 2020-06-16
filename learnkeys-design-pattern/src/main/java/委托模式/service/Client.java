package 委托模式.service;

/**
 * @author zhout
 * @date 2020/6/16 10:51
 */
class Client {

  private BusinessDelegate businessDelegate;

  public Client(BusinessDelegate businessDelegate) {
    this.businessDelegate = businessDelegate;
  }

  public void doTask() {
    businessDelegate.doTask();
  }
}
