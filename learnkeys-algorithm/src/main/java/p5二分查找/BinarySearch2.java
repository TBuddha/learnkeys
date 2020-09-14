package p5二分查找;

import lombok.NonNull;
import repo.In;
import repo.StdIn;
import repo.StdOut;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhout
 * @date 2020/9/11 17:40
 */
public class BinarySearch2 {

  public static int rank(int key, int[] a) {
    // 数组必须是有序的
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      // 被查找的键要么不存在，要么必然存在于a[lo..hi]之中
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args) {

    int[] whitelist = strArrayToIntArray(args[0].split(","));
            //In.readInts(args[0]);
    Arrays.sort(whitelist);
    while (!StdIn.isEmpty()) { // 读取键值，如果不存在于白名单中则将其打印
      int key = StdIn.readInt();
      if (rank(key, whitelist) < 0) StdOut.println(key);
    }
  }

  public static int[] strArrayToIntArray(String[] a){
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      b[i] = Integer.parseInt(a[i]);
    }
    return b;
  }
}
