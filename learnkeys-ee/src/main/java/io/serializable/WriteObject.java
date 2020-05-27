package io.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author zhouT
 * @date 2018/12/17 11:36
 */
public class WriteObject {
  public static void main(String[] args) {
    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
      Person person = new Person("kong", 500);
      // 将person对象写入输出流
      oos.writeObject(person);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
