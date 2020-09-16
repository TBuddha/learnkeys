package p5二分查找;

/**
 * @author zhout
 * @date 2020/9/11 17:40
 */
public class BinarySearch2 {

  /**
   * 数组必须是有序的
   *
   * @param key 查找的元素
   * @param a 数组
   * @return 元素索引，不存在返回-1
   */
  public static int rank(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;

    // 被查找的键要么不存在，要么必然存在于a[lo..hi]之中
    while (lo <= hi) {
      // 不断将数组的中间键（索引为mid ）和被查找的键比较。
      // 如果被查找的键等于 a[mid] ，返回 mid ；
      // 否则算法就将查找范围缩小一半，
      // 如果被查找的键小于 a[mid]，就继续在左半边查找，如果被查找的键大于 a[mid] 就继续在右半边查找
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(rank(8, new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
  }

  //  public static void main(String[] args) {
  //
  //    int[] whitelist = strArrayToIntArray(args[0].split(","));
  //            //In.readInts(args[0]);
  //    Arrays.sort(whitelist);
  //    while (!StdIn.isEmpty()) { // 读取键值，如果不存在于白名单中则将其打印
  //      int key = StdIn.readInt();
  //      if (rank(key, whitelist) < 0) StdOut.println(key);
  //    }
  //  }
  //
  //  public static int[] strArrayToIntArray(String[] a) {
  //    int[] b = new int[a.length];
  //    for (int i = 0; i < a.length; i++) {
  //      b[i] = Integer.parseInt(a[i]);
  //    }
  //    return b;
  //  }
}
