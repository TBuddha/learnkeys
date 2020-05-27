package reflect.创建对象;

import com.google.common.collect.Maps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhoutao
 * @date 2019/8/12 10:22
 */
public class ObjectPoolFactory {

  // 定义一个对象池,前面是对象名，后面是实际对象
  private Map<String, Object> objectPool = Maps.newHashMap();

  // 定义一个创建对象的方法，
  // 该方法只要传入一个字符串类名，程序可以根据该类名生成Java对象
  private Object createObject(String clazzName)
      throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    // 根据字符串来获取对应的Class对象
    Class<?> clazz = Class.forName(clazzName);
    // 使用clazz对应类的默认构造器创建实例
    return clazz.newInstance();
  }

  // 该方法根据指定文件来初始化对象池，
  // 它会根据配置文件来创建对象
  private void initPool(String fileName)
      throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    try (FileInputStream fis = new FileInputStream(fileName)) {
      Properties properties = new Properties();
      properties.load(fis);
      for (String name : properties.stringPropertyNames()) {
        // 每取出一对属性名－属性值对，就根据属性值创建一个对象
        // 调用createObject创建对象，并将对象添加到对象池中
        objectPool.put(name, createObject(properties.getProperty(name)));
      }
    } catch (IOException e) {
      System.out.println("读取" + fileName + "异常");
    }
  }

  private Object getObject(String name) {
    // 从objectPool中取出指定name对应的对象。
    return objectPool.get(name);
  }

  public static void main(String[] args) throws Exception {
    ObjectPoolFactory pf = new ObjectPoolFactory();
    pf.initPool("D:/idea_Project/YJ/SpraceXBootDemo/web-start/src/main/resources/obj.txt");
    System.out.println(pf.getObject("a"));
    System.out.println(pf.getObject("b"));
  }
}
