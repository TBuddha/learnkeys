package org.example.c11处理概括关系.p3构造函数本体上移;

/**
 * @author zhout
 * @date 2020/5/7 16:55
 */
class Employee {
  protected String _name;
  protected String _id;

  // 一、Employee 的值域应该在Employee 构造函数中被设妥初值。
  // 因此我定义了一个Employee 构造函数，并将它声明为protected，表示subclass 应该调用它：
  protected Employee(String name, String id) {
    _name = name;
    _id = id;
  }

  // 四、我不能把调用assignCar() 的行为移到superclass 构造函数中，
  // 因为惟有把合适的值赋给_grade 值域后才能执行assignCar() 。此时我需要Extract Method 和 Pull Up Method。
  void initialize() {
    if (isPrivileged()) assignCar();
  }

  // 特权
  boolean isPrivileged() {
    return true;
  }

  // 分配汽车
  void assignCar() {}
}
