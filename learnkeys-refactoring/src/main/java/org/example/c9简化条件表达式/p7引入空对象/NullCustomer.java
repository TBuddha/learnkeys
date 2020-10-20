package org.example.c9简化条件表达式.p7引入空对象;

/**
 * 这个系统中可能使用许多Site 和Customer ，它们都必须检查Customer 对象是否等于null ，而这样的检查完全是重复的。 看来是使用null object 的时候了。
 * 首先新建一个NullCustomer ，并修改Customer ，使其支持「对象是否为null」的检查：
 *
 *
 * @author zhout
 * @date 2020/4/28 15:25
 */
class NullCustomer extends Customer {

  public boolean isNull() {
    return true;
  }

  public String getName() {
    return "occupant";
  }

  public void setPlan(BillingPlan arg) {}

  public PaymentHistory getHistory() {
    return PaymentHistory.newNull();
  }
}
