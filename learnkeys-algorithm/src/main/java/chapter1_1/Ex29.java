package chapter1_1;

import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/9/22 17:18
 */
public class Ex29 {
  // 等值键。为 BinarySearch 类添加一个静态方法 rank()，
  // 它接受一个键和一个整型有序数组(可能存在重复键)作为参数并返回数组中小于该键的元素数量，
  // 以及一个类似的方法 count() 来 返回数组中等于该键的元素的数量。
  // 注意:如果 i 和 j 分别是 rank(key,a) 和 count(key,a) 的返回值，那么 a[i..i+j-1]
  // 就是数组中所有和 key 相等的元素。
  public static void main(String[] args) {
    int[] a =
        new int[] {84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 33, 16, 77, 11, 29, 11, 29, 77, 77};
    Arrays.sort(a);

    System.out.println(rank(29, a));
    System.out.println(count(48, a));
  }

  public static int rank(int key, int[] a) {
    int low = 0;
    int high = a.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (a[mid] == key) {
        while (mid >= 0 && a[mid] == key) {
          mid--;
        }
        return ++mid;
      } else if (a[mid] < key) {
        low = mid + 1;
      } else if (a[mid] > key) {
        high = mid - 1;
      }
    }
    return -1;
  }

  public static int count(int key, int[] a) {
    int num = 1;
    // 比key小的值没有必要再比较了
    int pos = rank(key, a);
    while (pos < a.length - 1 && a[pos] == a[++pos]) {
      num++;
    }
    return num;
  }
}
