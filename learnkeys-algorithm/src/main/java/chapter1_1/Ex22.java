package chapter1_1;

/**
 * @author zhout
 * @date 2020/9/17 14:52
 */
public class Ex22 {

  // 使用 1.1.6.4 节中的 rank() 递归方法重新实现 BinarySearch 并跟踪该方法的调用。
  // 每当该方法被调用时，打印出它的参数 lo 和 hi 并按照递归的深度缩进。
  // 提示：为递归方法添加一个参数来保存递归的深度。
  public static int rank(int key, int[] a) {
    return rank(key, a, 0, a.length - 1, 0);
  }

  /**
   *
   * @param key 查找元素
   * @param a   搜索数组
   * @param lo  低地址下标
   * @param hi  高地址下标
   * @param depth 深度
   */
  public static int rank(int key, int[] a, int lo, int hi, int depth) {
    for (int i = 0; i < depth; i++) {
      System.out.print("  ");
    }
    System.out.println("lo=" + lo + ", hi=" + hi);
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1, depth + 1);
    } else if (key > a[mid]) {
      return rank(key, a, mid + 1, hi, depth + 1);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 12};
    int key = 5;
    int pos = rank(key, a);
    if (pos == -1) {
      System.out.println("not found!");
    } else {
      System.out.println("position=" + pos);
    }
  }
}
