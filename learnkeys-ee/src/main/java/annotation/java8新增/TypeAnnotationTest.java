package annotation.java8新增;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/6/21 15:55
 */
// 可以在任何用到类型的地方使用
@Target(ElementType.TYPE_USE)
@interface NotNull {}

@NotNull
public class TypeAnnotationTest implements @NotNull Serializable {

  public static void main(@NotNull String[] args) throws @NotNull FileNotFoundException {
    Object obj = "dsad";
    String str = (@NotNull String) obj;
    Object object = new @NotNull String();
  }

  public void test(List<@NotNull String> info) {}
}
