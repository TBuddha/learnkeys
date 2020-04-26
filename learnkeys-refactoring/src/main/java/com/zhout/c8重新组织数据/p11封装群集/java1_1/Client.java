package com.zhout.c8重新组织数据.p11封装群集.java1_1;

import com.zhout.c8重新组织数据.p11封装群集.java2.Course;

import java.util.Vector;

/**
 * @author zhout
 * @date 2020/4/24 11:12
 */
public class Client {

  public void test() {
    Person kent = new Person();
    // 修改取值函数（getter）调用点，让它们改用新建的修改函数（modifiers）。 于是下列代码：
    // kent.getCourses().addElement(new Course("Brutal Sarcasm", false));
    // 就变成了==>
    kent.addCourse(new Course("Brutal Sarcasm", false));
  }
}
