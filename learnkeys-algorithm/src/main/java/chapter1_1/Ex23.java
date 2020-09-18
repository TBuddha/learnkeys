package chapter1_1;

import repo.In;
import repo.StdIn;
import repo.StdOut;

import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/9/17 15:05
 */
public class Ex23 {

  // 为BinarySearch 的测试用例添加一个参数：
  // + 打印出标准输入中不 在白名单上的值；- ，则打印出标准输入中在 白名单上的值
  // 简单来说
  // 该参数为‘+’时，输入要查找的数字，如果没有找到，则打印这个数字，如果找到了，则不打印
  // 该参数为‘-’时，输入要查找的数字，如果没有找到，则不打印，如果找到了，则打印这个数字
  public static int rank(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] whitelist = {1, 2, 3, 4, 6, 7, 8, 9, 12};
    Arrays.sort(whitelist);

    System.out.println("请输入-或者+");
    char arg = StdIn.readChar();

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();

      if (arg == '+' && (rank(key, whitelist) == -1)) {
        StdOut.println(key);
      }
      if (arg == '-' && (rank(key, whitelist) != -1)) {
        StdOut.println(key);
      }
    }
  }

  //  public static void main(String[] args) {
  //    int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 12};
  //    System.out.printf("+ or - ? ");
  //    char arg = StdIn.readChar();
  //    StdIn.readLine();
  //    System.out.printf("Input keys: ");
  //    String[] keys = StdIn.readLine().split(" ");
  //    for (int i = 0; i < keys.length; i++) {
  //      if (rank(Integer.parseInt(keys[i]), a) != -1 && arg == '-') {
  //        System.out.printf("%s ", keys[i]);
  //      } else if (rank(Integer.parseInt(keys[i]), a) == -1 && arg == '+') {
  //        System.out.printf("%s ", keys[i]);
  //      }
  //    }
  //    System.out.println();
  //  }
}
