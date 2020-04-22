package com.zhout.c8重新组织数据.p7将单向关联改为双向;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhout
 * @date 2020/4/21 11:13
 */
public class Customer {

  // 首先，我要为Customer添加一个值域。由于一个客户可以拥有多份定单，所以这个新增值域应该是个群集（collection）。
  // 我不希望同一份定单在同一个群集中出现一次以上，所以这里适合使用set：
  private Set _orders = new HashSet();

  // default级别，使其可见程度降到最低
  Set friendOrders() {
    // should only be used by Order when modifying the association
    // 仅应在修改关联时由Order使用
    return _orders;
  }

  // 希望在Customer 中也能修改连接（link），就让它调用控制函数
  void addOrder(Order arg) {
    arg.setCustomer(this);
  }
}
