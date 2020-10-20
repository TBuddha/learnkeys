package org.example.c10简化函数调用.p12以工厂函数取代构造函数;

/**
 * @author zhout
 * @date 2020/5/6 16:49
 */
class Demo {

  // 你希望在创建对象时不仅仅是对它做简单的建构动作（simple construction ）。
  // 将constructor （构造函数）替换为factory method（工厂函数）。

  //  Employee(int type) {
  //    _type = type;
  //  }

  // =>

  //  static Employee create(int type) {
  //    return new Employee(type);
  //  }
}
