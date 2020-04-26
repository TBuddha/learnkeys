package com.zhout.c8重新组织数据.p12以类取代型别码;

/**
 * 每个人都拥有四种血型中的一种。我们以Person 来表示「人」，以其中的type code 表示「血型」
 *
 * @author zhout
 * @date 2020/4/24 14:38
 */
class Person {

  /** 修改完毕Person 的所有用户之后，我就可以删掉原本使用整数型别的那些旧的取值函数、构造函数、静态变量和设值函数了 */
  //  public static final int O = 0;
  //  public static final int A = 1;
  //  public static final int B = 2;
  //  public static final int AB = 3;

  //  public Person(int bloodGroup) {
  //    _bloodGroup = bloodGroup;
  //  }
  //
  //  public void setBloodGroup(int arg) {
  //    _bloodGroup = arg;
  //  }

  //  public int getBloodGroup() {
  //    return _bloodGroup;
  //  }

  //  private int _bloodGroup;
  // ==>我把Person中的类型码改为使用BloodGroup class
  private BloodGroup _bloodGroup;

  //  public Person(int bloodGroup) {
  //    _bloodGroup = BloodGroup.code(bloodGroup);
  //  }
  // ==>建立新的构造函数也使用BloodGroup :
  public Person(BloodGroup bloodGroup) {
    _bloodGroup = bloodGroup;
  }

  //  public int getBloodGroup() {
  //    return _bloodGroup.getCode();
  //  }
  // ==>使用Rename Method修改类型码访问函数的名称，说明当前情况
  //  public int getBloodGroupCode() {
  //    return _bloodGroup.getCode();
  //  }

  // 为Person 加入一个新的取值函数（getter），其中使用BloodGroup
  public BloodGroup getBloodGroup() {
    return _bloodGroup;
  }

  //  public void setBloodGroup(int arg) {
  //    _bloodGroup = BloodGroup.code(arg);
  //  }
  // ==>设值函数（setter）,也使用BloodGroup :
  public void setBloodGroup(BloodGroup arg) {
    _bloodGroup = arg;
  }
}
