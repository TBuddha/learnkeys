package 委托模式.service;

/**
 * @author zhout
 * @date 2020/6/16 10:49
 */
class BusinessDelegate {

  private BusinessLookup businessLookup;

  private BusinessService businessService;

  private ServerType serverType;

  public void setBusinessLookup(BusinessLookup businessLookup) {
    this.businessLookup = businessLookup;
  }

  public void setServerType(ServerType serverType) {
    this.serverType = serverType;
  }

  /** 委派方法，其实最终调用的是业务类的方法 */
  public void doTask() {
    businessService = businessLookup.getBusinessService(serverType);
    businessService.doService();
  }
}
