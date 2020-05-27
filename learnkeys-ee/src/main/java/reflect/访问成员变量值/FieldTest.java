package reflect.访问成员变量值;

import java.lang.reflect.Field;

/**
 * @author zhoutao
 * @date 2019/8/13 14:12
 */
class Person {

  private String name;
  private int age;

  public String toString() {
    return "Person [ name:" + name + " , age:" + age + " ]";
  }
}

public class FieldTest {

  public static void main(String[] args) throws Exception {
    // 创建一个Person对象
    Person p = new Person();

    // 获取Person类对应的Class对象
    Class<Person> personClazz = Person.class;

    // 获取Person类名为name的属性
    // 使用getDeclaredField，表明可获取各种访问控制符的field
    Field nameField = personClazz.getDeclaredField("name");

    // 设置通过反射访问该Field时取消访问权限检查
    nameField.setAccessible(true);

    // 调用set方法为p对象的指定Field设置值
    nameField.set(p, "GM");

    // 获取Person类名为age的属性
    Field ageField = personClazz.getDeclaredField("age");

    // 设置通过反射访问该Field时取消访问权限检查
    ageField.setAccessible(true);

    // 调用setInt方法为p对象的指定Field设置值
    ageField.setInt(p, 30);
    System.out.println(p);
  }
}
