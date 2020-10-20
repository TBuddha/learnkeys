package org.example.c9简化条件表达式.p8引入断言;

import lombok.Data;

/**
 * @author zhout
 * @date 2020/4/28 16:45
 */
@Data
class Demo {

  //  double getExpenseLimit() {//费用限额
  //    // should have either expense limit or a primary project，应该有费用限制或主要项目
  //    return (_expenseLimit != NULL_EXPENSE)
  //        ? _expenseLimit
  //        : _primaryProject.getMemberExpenseLimit();
  //  }
  // =>
  //  double getExpenseLimit() {
  //    Assert.isTrue (_expenseLimit != NULL_EXPENSE || _primaryProject != null);
  //    return (_expenseLimit != NULL_EXPENSE) ?
  //            _expenseLimit:
  //            _primaryProject.getMemberExpenseLimit();
  //  }
}
