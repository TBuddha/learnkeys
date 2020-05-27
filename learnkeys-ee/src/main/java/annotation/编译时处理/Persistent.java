package annotation.编译时处理;

import java.lang.annotation.*;

/**
 * @author zhoutao
 * @date 2019/6/21 16:13
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Persistent {
  String table();
}
