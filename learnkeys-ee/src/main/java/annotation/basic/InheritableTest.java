package annotation.basic;

/**
 * @author zhoutao
 * @date 2019/6/21 14:27
 */
@Inheritable
// 使用@Inheritable修饰的Base类
class Base {}

// TestInheritable类只是继承了Base类，
// 并未直接使用@Inheritable Annotiation修饰

public class InheritableTest extends Base {
  public static void main(String[] args) {
    // 打印TestInheritable类是否具有Inheritable annotation
    System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
  }
}
