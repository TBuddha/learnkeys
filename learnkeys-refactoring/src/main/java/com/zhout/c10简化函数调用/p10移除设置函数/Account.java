package com.zhout.c10简化函数调用.p10移除设置函数;

/**
 * 你的class 中的某个值域，应该在对象初创时被设值，然后就不再改变。 去掉该值域的所有设值函数（setter）
 *
 * @author zhout
 * @date 2020/5/6 16:17
 */
class Account {

  // private String _id;

  //  Account (String id) {
  //    setId(id);
  //  }
  //
  //  void setId (String arg) {
  //    _id = arg;
  //  }
  // 以上代码可修改为：=>
  private final String _id;

  Account(String id) {
    _id = id;
  }
}
