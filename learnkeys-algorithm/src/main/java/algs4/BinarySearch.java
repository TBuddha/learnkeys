package algs4;

import repo.In;
import repo.StdIn;
import repo.StdOut;

import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/9/21 16:41
 */
public class BinarySearch {
  /** This class should not be instantiated. */
  private BinarySearch() {}

  /**
   * Returns the index of the specified key in the specified array.
   *
   * @param a the array of integers, must be sorted in ascending order
   * @param key the search key
   * @return index of key in array {@code a} if present; {@code -1} otherwise
   */
  public static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  /**
   * Returns the index of the specified key in the specified array. This function is poorly named
   * because it does not give the <em>rank</em> if the array has duplicate keys or if the key is not
   * in the array.
   *
   * @param key the search key
   * @param a the array of integers, must be sorted in ascending order
   * @return index of key in array {@code a} if present; {@code -1} otherwise
   * @deprecated Replaced by {@link #indexOf(int[], int)}.
   */
  @Deprecated
  public static int rank(int key, int[] a) {
    return indexOf(a, key);
  }

  /**
   * Reads in a sequence of integers from the whitelist file, specified as a command-line argument;
   * reads in integers from standard input; prints to standard output those integers that do
   * <em>not</em> appear in the file.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {

    // read the integers from a file
    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();

    // sort the array
    Arrays.sort(whitelist);

    // read integer key from standard input; print if not in whitelist
    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (BinarySearch.indexOf(whitelist, key) == -1) StdOut.println(key);
    }
  }
}
