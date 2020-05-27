package annotation.编译时处理;

import java.lang.annotation.*;

/**
 * @author zhoutao
 * @date 2019/6/21 16:14
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface Id {
  String column();

  String type();

  String generator();
}
