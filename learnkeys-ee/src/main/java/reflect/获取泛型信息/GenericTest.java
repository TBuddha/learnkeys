package reflect.获取泛型信息;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author zhoutao
 * @date 2019/8/14 16:48
 */
public class GenericTest {

  private Map<String, Integer> score;

  public static void main(String[] args) throws Exception {
    Class<GenericTest> clazz = GenericTest.class;
    Field field = clazz.getDeclaredField("score");

    // 直接使用getType()取出Field类型只对普通类型的Field有效
    Class<?> fieldType = field.getType();
    System.out.println("score的类型是:" + fieldType);

    // 获得Field实例f的泛型类型
    Type genericType = field.getGenericType();

    // 如果genericType类型是ParameterizedType对象
    if (genericType instanceof ParameterizedType) {
      // 强制类型转换
      ParameterizedType parameterizedType = (ParameterizedType) genericType;

      // 获取原来类型
      Type rType = parameterizedType.getRawType();
      System.out.println("原始类型是：" + rType);

      // 取得泛型类型的泛型参数
      Type[] tArgs = parameterizedType.getActualTypeArguments();

      System.out.println("泛型类型是:");
      for (int i = 0; i < tArgs.length; i++) {
        System.out.println("第" + i + "个泛型类型是：" + tArgs[i]);
      }
    } else {
      System.out.println("获取泛型类型出错！");
    }
  }
}
