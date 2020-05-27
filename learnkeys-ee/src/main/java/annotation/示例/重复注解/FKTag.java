package annotation.示例.重复注解;

import java.lang.annotation.*;

/**
 * @author zhoutao
 * @date 2019/6/21 15:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
// 容器
@Repeatable(FKTags.class)
public @interface FKTag {

  String name() default "aa";

  int age();
}
