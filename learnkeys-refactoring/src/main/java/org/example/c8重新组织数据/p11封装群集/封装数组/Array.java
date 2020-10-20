package org.example.c8重新组织数据.p11封装群集.封装数组;

/**
 * @author zhout
 * @date 2020/4/24 14:02
 */
class Array {

  String[] _skills;

  //  String[] getSkills() {
  //    return _skills;
  //  }
  // ==>
  // 修改取值函数（getter），令它返回一份数组拷贝
  String[] getSkills() {
    String[] result = new String[_skills.length];
    System.arraycopy(_skills, 0, result, 0, _skills.length);
    return result;
  }

  void setSkills(String[] arg) {
    _skills = arg;
  }

  // 首先我要提供一个修改函数（modifier）。由于用户有可能修改数组中某一特定位置上的值，所以我提供的setSkill()必须能对任何特定位置上的元素赋值
  void setSkill(int index, String newSkill) {
    _skills[index] = newSkill;
  }

  // 如果我需要对整个数组赋值，可以使用下列函数：
  void setAllSkills(String[] arg) {
    _skills = new String[arg.length];
    for (int i = 0; i < arg.length; i++) setSkill(i, arg[i]);
  }
}
