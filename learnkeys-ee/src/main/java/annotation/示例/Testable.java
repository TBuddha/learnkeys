package annotation.示例;

import java.lang.annotation.*;

/**
 * @author zhoutao
 * @date 2019/6/21 14:47
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Testable {}
