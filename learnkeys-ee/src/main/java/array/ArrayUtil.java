package array;

import java.util.Arrays;

/**
 * @author zhouT
 * @date 2019/5/9 16:21
 */
public class ArrayUtil {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 66, 7};
    String[] str = new String[] {"ds", "few"};
    System.out.println(Arrays.binarySearch(str, "few"));
  }
}
