package com.zhout.c7在对象之间搬移特性.p6移除中间人;

/**
 * @author zhout
 * @date 2020/5/14 09:34
 */
class Client {

  public void demo() {
    // 为了找出某人的经理，客户代码可能这样写：

    // manager = john.getManager();

    // 像这样，使用和封装Department都很简单。但如果大量函数都这么做，我就不得不在Person之中安置大量委托行为（delegations）。
    // 这就是移除中间人的时候了。
    // 首先在Person建立一个「受托对象（delegate）取得函数」：
    // public Department getDepartment() {
    //       return _department;
    //   }

    // 然后逐一处理每个委托函数。针对每一个这样的函数，我要找出通过Person使用的函数，并对它进行修改，使它首先获得受托对象（delegate），然后直接使用之：
    // manager = john.getDepartment().getManager();

    // 然后我就可以删除Person的getManager() 函数。如果我遗漏了什么，编译器会 告诉我。
  }
}
