package org.example.c8重新组织数据.p11封装群集.封装数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数组换成list
 *
 * @author zhout
 * @date 2020/4/24 14:07
 */
class Person {

  List _skills = new ArrayList();

  String[] getSkills() {
    return (String[]) _skills.toArray(new String[0]);
  }

  void setSkill(int index, String newSkill) {
    _skills.set(index, newSkill);
  }
}
