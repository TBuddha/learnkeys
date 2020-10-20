package org.example.c10简化函数调用.p12以工厂函数取代构造函数;

/**
 * @author zhout
 * @date 2020/5/6 16:56
 */
class Employee {
  private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  // 3、
  //  Employee(int type) {
  //    _type = type;
  //  }

  private Employee(int type) {
    _type = type;
  }

  // 1、我希望为Employee 提供不同的subclasses，并分别给予它们相应的type code。因此，我需要建立一个factory method ：
  static Employee create(int type) {
    return new Employee(type);
  }

  // 2、然后，我要修改构造函数的所有调用点，让它们改用上述新建的factory method ， 并将构造函数声明为private ：
  // client code...
  public void client() {
    Employee eng = Employee.create(Employee.ENGINEER);
  }
}
