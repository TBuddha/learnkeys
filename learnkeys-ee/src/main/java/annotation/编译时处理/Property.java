package annotation.编译时处理;

import java.lang.annotation.*;

/**
 * @author zhoutao
 * @date 2019/6/21 16:15
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Property {
  String column();

  String type();
}
