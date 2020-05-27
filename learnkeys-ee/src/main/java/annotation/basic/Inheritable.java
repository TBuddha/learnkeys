package annotation.basic;

import java.lang.annotation.*;

/**
 * @author zhoutao
 * @date 2019/6/21 14:26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Inheritable {}
