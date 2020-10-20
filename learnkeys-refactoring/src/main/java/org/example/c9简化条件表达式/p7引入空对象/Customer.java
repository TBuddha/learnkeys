package org.example.c9简化条件表达式.p7引入空对象;

/**
 * @author zhout
 * @date 2020/4/28 15:30
 */
// class Customer {
class Customer implements Nullable {

  public String getName() {
    return "";
  }

  public BillingPlan getPlan() {
    return null;
  }

  public PaymentHistory getHistory() {
    return null;
  }

  public void setPlan(BillingPlan arg){

  }

  @Override
  public boolean isNull() {
    return false;
  }

  protected Customer() {} // needed by the NullCustomer

  // 我还喜欢加入一个factory method，专门用来创建NullCustomer 对象。这样一来，用户就不必知道null class 的存在了：
  static Customer newNull() {
    return new NullCustomer();
  }

}
