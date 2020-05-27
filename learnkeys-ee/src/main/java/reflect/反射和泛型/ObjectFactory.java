package reflect.反射和泛型;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.Date;

/**
 * @author zhoutao
 * @date 2019/8/14 15:30
 */
@Slf4j
public class ObjectFactory {

  /*public static Object getInstance(String className){
    try {
      Class clazz = Class.forName(className);
      return clazz.newInstance();
    } catch (Exception e) {
     log.info("error",e);
      return null;
    }
  }

  public static void main(String[] args) {
    Date date = (Date) getInstance("java.util.Date");
    System.out.println(date);
    JFrame jFrame = (JFrame)getInstance("java.util.Date");
    System.out.println();
  }*/

  // 使用泛型避免强制类型转换
  public static <T> T getInstance(Class<T> className) {
    try {
      return className.newInstance();
    } catch (Exception e) {
      log.info("error", e);
      return null;
    }
  }

  public static void main(String[] args) {
    Date date = getInstance(Date.class);
    System.out.println(date);

    JFrame jFrame = getInstance(JFrame.class);
    System.out.println(jFrame);
  }
}
