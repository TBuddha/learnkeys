package annotation.示例.listener;

import java.awt.event.ActionListener;
import java.lang.annotation.*;

/**
 * @author zhoutao
 * @date 2019/6/21 15:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ActionListenerFor {
  // 定义一个成员变量，用于设置元数据
  // 该listener成员变量用于保存监听器实现类
  Class<? extends ActionListener> listener();
}
