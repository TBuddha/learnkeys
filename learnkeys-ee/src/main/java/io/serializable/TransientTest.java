package io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author zhouT
 * @date 2018/12/19 16:10
 */
public class TransientTest {
  public static void main(String[] args) {
    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transient.txt"));

      Person person = new Person("sun", 400);
      oos.writeObject(person);
      Person p = (Person) ois.readObject();
      System.out.println(p.getName() + "---" + p.getAge());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
