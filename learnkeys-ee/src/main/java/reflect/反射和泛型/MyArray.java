package reflect.反射和泛型;

import java.lang.reflect.Array;

/**
 * @author zhoutao
 * @date 2019/8/14 16:00
 */
public class MyArray {

  // 对Array的newInstance方法进行包装
  @SuppressWarnings("unchecked")
  public static <T> T[] newInstance(Class<T> componentType, int length) {
    return (T[]) Array.newInstance(componentType, length);
  }

  public static void main(String[] args) {
    // 使用MyArray的newInstance()创建一维数组
    String[] arr = MyArray.newInstance(String.class, 10);
    arr[5] = "GM";
    System.out.println(arr[5]);

    // 使用MyArray的newInstance()创建二维数组
    // 在这种情况下，只要设置数组元素的类型是int[]即可。
    int[][] intArr = MyArray.newInstance(int[].class, 5);

    // intArr是二维数组，初始化该数组的第二个数组元素——数组元素必须是一维数组
    intArr[1] = new int[] {23, 12};

    System.out.println(intArr[1][1]);
  }
}
