package com.zhout.c9简化条件表达式.p7引入空对象;

/**
 * @author zhout
 * @date 2020/4/28 15:25
 */
class Client {
  // 上面的各种取值函数（getter）允许客户取得各种数据。但有时候一个地点的顾客搬走了，新顾客还没搬进来，此时这个地点就没有顾客。
  // 由于这种情况有可能发生，所以我们必须保证Customer
  // 的所有用户都能够处理「Customer 对象等于null」的情况。下面是一些示例片段
  public void test(Site site) {
    //    Customer customer = site.getCustomer();
    //    BillingPlan plan;
    //    if (customer == null) plan = BillingPlan.basic();
    //    else plan = customer.getPlan();
    //    // --------------------------------------------------//
    //    String customerName;
    //    if (customer == null) customerName = "occupant";
    //    else customerName = customer.getName();
    //    // --------------------------------------------------//
    //    int weeksDelinquent;
    //    if (customer == null) weeksDelinquent = 0;
    //    else weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();

    // 另外，我还要修改所有「使用Customer 对象」的地方，让它们以isNull() 函数进行检查，不再使用"== null"”检查方式
    //    Customer customer = site.getCustomer();
    //    BillingPlan plan;
    //    if (customer.isNull()) plan = BillingPlan.basic();
    //    else plan = customer.getPlan();
    //    // --------------------------------------------------//
    //    String customerName;
    //    if (customer.isNull()) customerName = "occupant";
    //    else customerName = customer.getName();
    //    // --------------------------------------------------//
    //    int weeksDelinquent;
    //    if (customer.isNull()) weeksDelinquent = 0;
    //    else weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();

    Customer customer = site.getCustomer();
    // =>
    String customerName = customer.getName();
    // =>
    customer.setPlan(BillingPlan.special());
    // 上述范例略带差异的某种情况是，某些客户端使用Customer 函数的运算结果
    //    int weeksDelinquent;
    //    if (customer.isNull()) weeksDelinquent = 0;
    //    else weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
    // =>
    int weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
  }
}
