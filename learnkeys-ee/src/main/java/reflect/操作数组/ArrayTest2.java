package reflect.操作数组;

import java.lang.reflect.Array;

/**
 * @author zhoutao
 * @date 2019/8/13 14:28
 */
public class ArrayTest2 {

  public static void main(String args[]) {
    /*创建一个三维数组。
      根据前面介绍数组时讲的：三维数组也是一维数组，是数组元素是
      二维数组的一维数组，因此可以认为arr是长度为3的一维数组
    */
    Object arr = Array.newInstance(String.class, 3, 4, 10);
    // 获取arr数组中index为2的元素，应该是二维数组
    Object arrObj = Array.get(arr, 2);
    // 使用Array为二维数组的数组元素赋值。
    // 二维数组的数组元素是一维数组，所以传入Array set方法的第三个参数是
    // 第三个参数是一维数组。
    Array.set(arrObj, 2, new String[] {"GM", "GT"});
    // 获取arrObj数组中index为3的元素，应该是一维数组。
    Object anArr = Array.get(arrObj, 3);
    Array.set(anArr, 8, "GDD");
    // 将arr强制类型转换为三维数组
    String[][][] cast = (String[][][]) arr;
    // 获取cast三维数组中指定元素的值
    System.out.println(cast[2][3][8]);
    System.out.println(cast[2][2][0]);
    System.out.println(cast[2][2][1]);
  }
}
