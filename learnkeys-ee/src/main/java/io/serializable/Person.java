package io.serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author zhouT
 * @date 2018/12/17 11:33
 */
@Setter
@Getter
@AllArgsConstructor
public class Person implements Serializable {
  private String name;
  private int age;
  // private transient int age;

  // 注意没有提供无参的构造器

  /*private void writeObject(java内置.io.ObjectOutputStream out)
          throws java内置.io.IOException{
      //将name的实例变量反转后写入二进制流
      out.writeObject(new StringBuffer(name).reverse());
      out.writeInt(age);
  }

  private void readObject(java内置.io.ObjectInputStream in)
          throws java内置.io.IOException, ClassNotFoundException {
      //将读取的字符串反转后赋给name实例变量
      name = ((StringBuffer)in.readObject()).reverse().toString();
      age = in.readInt();
  }*/

  /*private Object writeReplace() throws ObjectStreamException{

  }*/

  // 重写writeReplace方法，程序在序列化该对象之前，先调用该方法
  private Object writeReplace() throws ObjectStreamException {
    ArrayList<Object> list = new ArrayList<Object>();
    list.add(name);
    list.add(age);
    return list;
  }
}
