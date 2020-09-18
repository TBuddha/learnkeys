package chapter1_1;

import repo.In;
import repo.StdIn;
import repo.StdOut;

import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/9/17 14:56
 */
public class Ex22_1 {
  public static int rank(int key, int[] a) {
    return rank(key, a, 0, a.length - 1, 1);
  }

  public static int rank(int key, int[] a, int lo, int hi, int depth) {
    // 如果key存在于a[]中，它的索引不会小于lo且不会大于hi

    for (int i = 0; i < depth; i++) {
      System.out.print(" ");
    }
    System.out.println("hi = " + hi + " lo = " + lo);
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1, ++depth);
    } else if (key > a[mid]) {
      return rank(key, a, mid + 1, hi, ++depth);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] whitelist = In.readInts(args[0]);
    // 注意这里的In是采用基于文件的输入，详情可以查看《算法》第25页
    // args[0]传入一个txt文本路径，比如/Users/zhout/work/demo_case/Test.txt
    // 这里Test.txt里的内容为11 22 33 44 55 66 77 88 99
    Arrays.sort(whitelist); // 将数组升序排序
    System.out.println("请输入您要查找的数字：");
    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      int rv = rank(key, whitelist);
      if (rv == -1) {
        StdOut.println("没有找到" + key + "这个元素"); // 如果没有找到就打印key的值
      } else {
        StdOut.println(key + "的下标为" + rv);
      }
      System.out.println("请输入您要查找的数字：");
    }
  }
}
