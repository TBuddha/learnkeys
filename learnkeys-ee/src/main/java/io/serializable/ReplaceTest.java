package io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author zhouT
 * @date 2018/12/19 19:56
 */
public class ReplaceTest {
  public static void main(String[] args) {
    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("replace.txt"));
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("replace.txt"));

      Person person = new Person("wu", 600);
      // 系统将person对象转换成字节序列并输出
      oos.writeObject(person);
      // 反序列化读取得到的是ArrayList
      ArrayList list = (ArrayList) ois.readObject();
      System.out.println(list);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
