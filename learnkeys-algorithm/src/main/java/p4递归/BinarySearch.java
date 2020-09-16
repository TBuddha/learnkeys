package p4递归;

/**
 * @author zhout
 * @date 2020/7/22 10:47
 * 二分查找的方式
 */
class BinarySearch {

  public static int rank(int key, int[] srcArray) {
    return rank(key, srcArray, 0, srcArray.length - 1);
  }

  /**
   * 二分查找递归实现。参考https://blog.csdn.net/qq_33951180/article/details/52454263
   *
   * @param srcArray 有序数组（升序或降序）！！！
   * @param key 查找元素
   * @param lo 数组低地址下标
   * @param hi 数组高地址下标
   * @return 查找元素索引，不存在返回-1
   */
  private static int rank(int key, int[] srcArray, int lo, int hi) {
    if (lo > hi) return -1; // 如果key存在于a[]中，它的索引不会小于lo且不会大于hi

    int mid = lo + (hi - lo) / 2; // 每次先找出这组数据的中间数（mid）

    // 如果要查找的数据（num）小于 mid ，那么就在前一半数据中查找；
    // 如果要查找的数据（num）大于 mid ，那么就在后一半数据中查找；
    if (key < srcArray[mid]) return rank(key, srcArray, lo, mid - 1);
    else if (key > srcArray[mid]) return rank(key, srcArray, mid + 1, hi);
    else return mid;
  }

  public static void main(String[] args) {
    System.out.println(rank(8, new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
  }
}
