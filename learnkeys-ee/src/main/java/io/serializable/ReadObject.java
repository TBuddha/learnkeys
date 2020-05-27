package io.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author zhouT
 * @date 2018/12/17 13:44
 */
public class ReadObject {
  public static void main(String[] args) {
    try {
      // 创建一个ObjectInputStream输入流
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));

      // 从输入流中读取一个java对象，并将其强制转换为Person类
      Person person = (Person) ois.readObject();
      System.out.println("名字为：" + person.getName() + "\n年龄为：" + person.getAge());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
