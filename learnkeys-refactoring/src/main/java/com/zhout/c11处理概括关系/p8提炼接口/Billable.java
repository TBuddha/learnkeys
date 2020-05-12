package com.zhout.c11处理概括关系.p8提炼接口;

/**
 * 除了提供员工的索费级别和特殊技能信息外，Employee 还有很多其他方面的功能， 但本应用程序只需这两项功能。我可以针对这两项功能定义一个接口，从而强调「我 只需要这部分功能」的事实：
 *
 * @author zhout
 * @date 2020/5/12 10:39
 */
interface Billable { // 可开票

  public int getRate();

  public boolean hasSpecialSkill();
}
