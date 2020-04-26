package com.zhout.c8重新组织数据.p11封装群集.java1_1;

import com.zhout.c8重新组织数据.p11封装群集.java2.Course;
import org.junit.Assert;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 在很多地方，Java 1.1的情况和Java 2非常相似。这里我使用同一个范例， 不过群集改为vector （译注：因为vector 属于Java 1.1，不属于Java 2）
 *
 * @author zhout
 * @date 2020/4/24 11:08
 */
class Person {

  public Vector getCourses() {
    // return _courses;
    // 因为Java 1.1的Vector class并没有提供「不可修改版」
    return (Vector) _courses.clone();
    /** 这样便完成了群集的封装。此后，如果不通过Person 提供的函数，谁也不能改变群集的元素 */
  }

  //  public void setCourses(Vector arg) {
  //    _courses = arg;
  //  }
  // ==>
  // 可以修改setCourses()来初始化这个vector
  public void initializeCourses(Vector arg) {
    Assert.assertTrue(_courses.isEmpty());
    Enumeration e = arg.elements();
    while (e.hasMoreElements()) {
      addCourse((Course) e.nextElement());
    }
  }

  /** 首先建立修改函数（modifiers：add/remove 函数），并初始化_courses值域 */
  public void addCourse(Course arg) {
    _courses.addElement(arg);
  }

  public void removeCourse(Course arg) {
    _courses.removeElement(arg);
  }

  // private Vector _courses;
  // ==>
  private Vector _courses = new Vector();
  /** ********************************************* */
}
