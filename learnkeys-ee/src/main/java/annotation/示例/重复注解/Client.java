package annotation.示例.重复注解;

/**
 * @author zhoutao
 * @date 2019/6/21 15:39
 */
public class Client {

  @FKTag(age = 13)
  @FKTag(age = 13)
  public void test() {}
}
