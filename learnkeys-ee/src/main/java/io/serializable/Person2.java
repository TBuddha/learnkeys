package io.serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author zhouT
 * @date 2018/12/19 20:27
 */
@Setter
@Getter
@AllArgsConstructor
public class Person2 implements Externalizable {

  private String name;
  private int age;

  // 注意没有提供无参的构造器

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    // 将name实例实例变量反转后写入二进制流
    out.writeObject(new StringBuffer(name).reverse());
    out.writeInt(age);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    // 将读取的字符串反转后赋给name实例变量
    name = ((StringBuffer) in.readObject()).reverse().toString();
    age = in.readInt();
  }
}
