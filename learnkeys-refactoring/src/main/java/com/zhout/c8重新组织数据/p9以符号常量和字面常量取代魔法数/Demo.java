package com.zhout.c8重新组织数据.p9以符号常量和字面常量取代魔法数;

/**
 * @author zhout
 * @date 2020/4/22 14:51
 */
public class Demo {

  //  double potentialEnergy(double mass, double height) {
  //    return mass * 9.81 * height;
  //  }

  // ==>

  static final double GRAVITATIONAL_CONSTANT = 9.81;

  double potentialEnergy(double mass, double height) {
    return mass * GRAVITATIONAL_CONSTANT * height;
  }
}
