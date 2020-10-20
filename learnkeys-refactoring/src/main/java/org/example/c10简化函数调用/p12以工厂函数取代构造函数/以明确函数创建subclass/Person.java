package org.example.c10简化函数调用.p12以工厂函数取代构造函数.以明确函数创建subclass;


/**
 * @author zhout
 * @date 2020/5/6 17:27
 */
class Person {
  static Person createMale() {
    return new Male();
  }

  static Person createFemale() {
    return new Female();
  }

  public void client() {
    Person kent = new Male();
    // 替换成：
    Person kent1 = Person.createMale();
  }
  // 但是这就使得superclass 必须知晓subclass 。如果想避免这种情况，你需要一个更为复杂的设计，例如 Product Trader 模式[Bäumer and
  // Riehle]。绝大多数情况下你并不需要如此复杂的设计，上面介绍的作法已经绰绰有余。
}
