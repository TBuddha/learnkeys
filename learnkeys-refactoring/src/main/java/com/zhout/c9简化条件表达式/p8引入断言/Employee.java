package com.zhout.c9简化条件表达式.p8引入断言;

import org.junit.Assert;

/**
 * 下面是一个简单例子：开支（经费）限制。后勤部门的员工每个月有固定的开支限额；业务部门的员工则按照项目的开支限额来控制自己的开支。
 * 一个员工可能没有开支额度可用，也可能没有参与项目，但两者总得要有一个（否则就没有经费可用了）。在开支限额相关程序中，上述假设总是成立的
 *
 * <p>assertion 的价值在于：帮助程序员理解代码正确运行的必要条件
 *
 * @author zhout
 * @date 2020/4/29 10:32
 */
class Employee {

  private static final double NULL_EXPENSE = -1.0; // 没有开支
  private double _expenseLimit = NULL_EXPENSE; // 开支限额
  private Project _primaryProject; // 主项目

  double getExpenseLimit() {
    return (_expenseLimit != NULL_EXPENSE)
        ? _expenseLimit
        : _primaryProject.getMemberExpenseLimit();
  }

  // 这段代码包含了一个明显假设：任何员工要不就参与某个项目，要不就有个人开支限额。我们可以使用assertion 在代码中更明确地指出这一点：
  double getExpenseLimit1() {
    Assert.assertTrue(_expenseLimit != NULL_EXPENSE || _primaryProject != null);
    return (_expenseLimit != NULL_EXPENSE)
        ? _expenseLimit
        : _primaryProject.getMemberExpenseLimit();
  }

  /**
   * Java 中使用assertions 有点麻烦：没有一种简单机制可以协助我们插入这东西[8]。 assertions
   * 可被轻松拿掉，所以它们不可能影响最终成品的性能。编写一个辅助类（例如Assert class）当然有所帮助，可惜的是assertions
   * 参数中的任何表达式不论什么情况都一定会被执行一遍。阻止它的惟一办法就是使用类似下面的手法：
   */
  //  double getExpenseLimit2() {
  //    Assert.isTrue(Assert.ON && (_expenseLimit != NULL_EXPENSE || _primaryProject != null));
  //    return (_expenseLimit != NULL_EXPENSE)
  //        ? _expenseLimit
  //        : _primaryProject.getMemberExpenseLimit();
  //  }
  //  // 或
  //  double getExpenseLimit() {
  //    if (Assert.ON) Assert.isTrue(_expenseLimit != NULL_EXPENSE || _primaryProject != null);
  //    return (_expenseLimit != NULL_EXPENSE) ?
  //            _expenseLimit:
  //            _primaryProject.getMemberExpenseLimit();
  //  }
  /**
   * 如果Assert.ON 是个常量，编译器（译注：而非运行期间）就会对它进行检查； 如果它等于false，
   * 就不再执行条件式后半段代码。但是，加上这条语句实在有点丑陋，所以很多程序员宁可仅仅使用Assert.isTrue() 函数，
   * 然后在项目结束前以过滤程序滤掉使用assertions的每一行代码（可以使用Perl 之类的语言来编写这样 的过滤程序）。
   * Assert class应该有多个函数，函数名称应该帮助程序员理解其功用。
   * 除了isTrue()之外，你还可以为它加上equals() 和shouldNeverReachHere() 等函数。
   */


  boolean withinLimit(double expenseAmount) {
    return (expenseAmount <= getExpenseLimit());
  }
}

class Project {
  // 获取会员费用限额
  double getMemberExpenseLimit() {
    return 0.0;
  }
}
