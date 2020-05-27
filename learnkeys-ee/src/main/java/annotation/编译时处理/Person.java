package annotation.编译时处理;

import lombok.Data;

/**
 * @author zhoutao
 * @date 2019/6/21 16:16
 */
@Persistent(table = "t_person")
@Data
public class Person {

  @Id(column = "person_id", type = "integer", generator = "identity")
  private int id;

  @Property(column = "person_name", type = "string")
  private String name;

  @Property(column = "person_age", type = "integer")
  private int age;

  public Person() {}

  public Person(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }
}
