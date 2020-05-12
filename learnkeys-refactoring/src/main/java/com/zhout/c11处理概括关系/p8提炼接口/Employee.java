package com.zhout.c11处理概括关系.p8提炼接口;

/**
 * @author zhout
 * @date 2020/5/12 10:36
 */
class Employee implements Billable {
  @Override
  public int getRate() { // 级别
    return 0;
  }

  @Override
  public boolean hasSpecialSkill() { // 特殊技能
    return false;
  }
}
