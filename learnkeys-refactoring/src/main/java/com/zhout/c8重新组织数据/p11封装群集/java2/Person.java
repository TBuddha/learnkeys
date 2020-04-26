package com.zhout.c8重新组织数据.p11封装群集.java2;

import org.junit.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhout
 * @date 2020/4/22 16:20
 */
class Person {

  // private Set _courses;
  private Set _courses = new HashSet();

  // 让取值函数（getter）返回一个只读映件（read-only view），用以确保没有任何一个用户能够通过取值函数（getter）修改群集：
  public Set getCourses() {
    // return _courses;
    return Collections.unmodifiableSet(_courses);
  }

  //  1
  //  public void setCourses(Set arg) {
  //    _courses = arg;
  //  }

  //  2、
  //  public void setCourses(Set arg) {
  //    Assert.assertTrue(_courses.isEmpty());
  //    Iterator iter = arg.iterator();
  //    while (iter.hasNext()) {
  //      addCourse((Course) iter.next());
  //    }
  //  }

  //  3、修改完毕后，最好以Rename Method 更明确地展示这个函数的意图
  //  public void initializeCourses(Set arg) {
  //    Assert.assertTrue(_courses.isEmpty());
  //    Iterator iter = arg.iterator();
  //    while (iter.hasNext()) {
  //      addCourse((Course) iter.next());
  //    }
  //  }

  // 4、如果我知道初始化时，除了添加元素，不会再有其他行为，那么我可以不使用循环， 直接调用addAll() 函数：
  public void initializeCourses(Set arg) {
    Assert.assertTrue(_courses.isEmpty());
    _courses.addAll(arg);
  }

  // 建立合适的修改函数
  public void addCourse(Course arg) {
    _courses.add(arg);
  }

  public void removeCourse(Course arg) {
    _courses.remove(arg);
  }
  // ---------------

  int numberOfAdvancedCourses(Person person) {
    Iterator iter = person.getCourses().iterator();
    int count = 0;
    while (iter.hasNext()) {
      Course each = (Course) iter.next();
      if (each.isAdvanced()) count++;
    }
    return count;
  }
  // ==>
  int numberOfAdvancedCourses() {
    Iterator iter = getCourses().iterator();
    int count = 0;
    while (iter.hasNext()) {
      Course each = (Course) iter.next();
      if (each.isAdvanced()) count++;
    }
    return count;
  }

  // example
  // kent.getCourses().size()
  // ==>
  // 可以修改成更具可读性的样子，像这样：
  //  kent.numberOfCourses()
  //  class Person...
  //  public int numberOfCourses() {
  //    return _courses.size();
  //  }
}
