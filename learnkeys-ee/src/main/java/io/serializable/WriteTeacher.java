package io.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author zhouT
 * @date 2018/12/19 10:53
 */
public class WriteTeacher {
  public static void main(String[] args) {
    // 创建一个ObjectOutputStream输出流
    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"));
      Person person = new Person("kong", 500);
      Teacher t1 = new Teacher("tang", person);
      Teacher t2 = new Teacher("pu", person);
      // 依次将4个对象写入输出流
      oos.writeObject(t1);
      oos.writeObject(t2);
      oos.writeObject(person);
      oos.writeObject(t2);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
