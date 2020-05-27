package io.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author zhouT
 * @date 2018/12/19 11:09
 */
public class ReadTeacher {
  public static void main(String[] args) {
    try {
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"));
      // 依次读取ObjectInputStream输入流中的4个对象
      Teacher t1 = (Teacher) ois.readObject();
      Teacher t2 = (Teacher) ois.readObject();
      Person p = (Person) ois.readObject();
      Teacher t3 = (Teacher) ois.readObject();

      System.out.println(t1.getStudent() == p);
      System.out.println(t2.getStudent() == p);
      System.out.println(t2 == t3);
      System.out.println(t1.getStudent() + "===" + p);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
