package annotation.示例.重复注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhoutao
 * @date 2019/6/21 15:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FKTags {
  // 定义value成员变量，改成员变量可接受多个@FKTag注解
  FKTag[] value();
}
