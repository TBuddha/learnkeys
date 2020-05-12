package com.zhout.c11处理概括关系.p3构造函数本体上移;

/**
 * @author zhout
 * @date 2020/5/7 16:59
 */
class Manager extends Employee {

  private int _grade; // 等级

  public Manager(String name, String id, int grade) {
    //    _name = name;
    //    _id = id;
    //    _grade = grade;

    // 二、然后，我从中调用它：
    //    super(name, id);
    //    _grade = grade;

    // 三、后来情况又有些变化，构造函数中出现了共同代码。假如我有以下代码：
    //    if (isPrivileged()) assignCar(); // every subclass does this

    // 四、我不能把调用assignCar() 的行为移到superclass 构造函数中，
    // 因为惟有把合适的值赋给_grade 值域后才能执行assignCar() 。此时我需要Extract Method 和 Pull Up Method。
    super(name, id);
    _grade = grade;
    initialize();
  }

  // 三、后来情况又有些变化，构造函数中出现了共同代码。假如我有以下代码：
  @Override
  boolean isPrivileged() {
    return _grade > 4;
  }
}
