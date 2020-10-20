package org.example.c8重新组织数据.p11封装群集.java2;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhout
 * @date 2020/4/22 16:21
 */
class Client {

  /** 添加课程 */
  public void addCourse() {
    Person kent = new Person();
    Set s = new HashSet();
    s.add(new Course("Smalltalk Programming", false));
    s.add(new Course("Appreciating Single Malts", true));
    //    kent.setCourses(s);
    //    Assert.assertEquals (2, kent.getCourses().size());

    Course refactor = new Course("Refactoring", true);
    kent.getCourses().add(refactor);
    kent.getCourses().add(new Course("Brutal Sarcasm", false));
    Assert.assertEquals(4, kent.getCourses().size());

    kent.getCourses().remove(refactor);
    Assert.assertEquals(3, kent.getCourses().size());
  }

  /** 高级课程 */
  public void AdvancedCourse(Person person) {
    Iterator iter = person.getCourses().iterator();
    int count = 0;
    while (iter.hasNext()) {
      Course each = (Course) iter.next();
      if (each.isAdvanced()) count++;
    }
  }
}
