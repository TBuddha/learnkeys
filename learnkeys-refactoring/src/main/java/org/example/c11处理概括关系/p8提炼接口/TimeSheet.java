package org.example.c11处理概括关系.p8提炼接口;

/**
 * TimeSheet class 表示「月报表」，其中将计算花在员工身上的费用。为了计算这笔费用，TimeSheet 需要知道员工级别，以及该员工是否有特殊技能：
 *
 * @author zhout
 * @date 2020/5/12 10:36
 */
class TimeSheet {

  //  double charge(Employee emp, int days) {
  //    int base = emp.getRate() * days;
  //    if (emp.hasSpecialSkill()) return base * 1.05;
  //    else return base;
  //  }
  // =>
  // 完成以后，我可以修改charge() 函数声明，强调该函数只使用Employee 的这部分行为：
  double charge(Billable emp, int days) {
    int base = emp.getRate() * days;
    if (emp.hasSpecialSkill()) return base * 1.05;
    else return base;
  }
}
