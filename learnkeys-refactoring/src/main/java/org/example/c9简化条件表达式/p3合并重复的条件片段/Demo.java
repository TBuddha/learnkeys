package org.example.c9简化条件表达式.p3合并重复的条件片段;

/**
 * Consolidate Duplicate Conditional Fragments（合并重复的条件片段)
 *
 * @author zhout
 * @date 2020/4/26 18:08
 */
class Demo {

  //  if (isSpecialDeal()) {
  //    total = price * 0.95;
  //    send();
  //  }
  //     else {
  //    total = price * 0.98;
  //    send();
  //  }
  // =>在条件式的每个分支上有着相同的一段代码。将这段重复代码搬移到条件式之外
  //   由于条件式的两个分支都执行了 send() 函数，所以我应该将send() 移到条件式的外围：
  //  if (isSpecialDeal())
  //  total = price * 0.95;
  //     else
  //  total = price * 0.98;
  //  send();
}
