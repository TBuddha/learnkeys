package com.zhout.c8重新组织数据.p15以值域取代子类.after;

/**
 * 本例之中，以Person 表示「人」，并针对每种性别建立一个subclass ：以Male subclass「男人」，以Female subclass 表示「女人」：
 *
 * @author zhout
 * @date 2020/4/26 11:07
 */
// abstract class Person {
// ==>删除Person中abstract 修饰
class Person {
  // abstract boolean isMale();

  // abstract char getCode();

  // 使用Replace Constructor with Factory Method 。在这里，我需要为每个subclass 建立一个factory method ：
  //  static Person createMale() {
  //    return new Male();
  //  }

  // ==>以Inline Method 将subclass 构造函数内联（inlining）到superclass 的factory method 中
  static Person createMale() {
    // return new Male();
    return new Person(true, 'M');
  }

  static Person createFemale() {
    // return new Female();
    return new Person(false, 'F');
  }
  // 然后我把对象创建过程从以下这样：
  // Person kent = new Male();
  // 改成这样：
  // Person kent = Person.createMale();
  // ------------------------------------//l

  // 针对每个常量函数，在superclass 中声明一个对应的值域：
  private final boolean _isMale;
  private final char _code;
  // 为superclass 加上一个protected 构造函数
  protected Person(boolean isMale, char code) {
    _isMale = isMale;
    _code = code;
  }

  // 在superclass 中加入访问这些值域的函数，并删掉subclass 中的常量函数
  boolean isMale() {
    return _isMale;
  }

  char getCode() {
    return _code;
  }
}
