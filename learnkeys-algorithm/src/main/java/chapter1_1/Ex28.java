package chapter1_1;

import algs4.BinarySearch;
import org.junit.Test;
import repo.In;
import repo.StdIn;
import repo.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhout
 * @date 2020/9/21 16:30
 */
public class Ex28 {

  // “删除重复元素 。修改BinarySearch 类中的测试用例，来删去排序之后白名单中的所有重复元素”
  @Test
  public void test() {
    int[] whitelist = {7, 1, 5, 1, 9, 5, 7, 7, 5, 1};
    a1(whitelist, 7);
  }

  private static void a1(int[] whiteArray, int key) {
    Arrays.sort(whiteArray);
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < whiteArray.length - 1; i++) {
      if (whiteArray[i] != whiteArray[i + 1]) {
        list.add(whiteArray[i]);
      }
    }
    list.add(whiteArray[whiteArray.length - 1]);

    whiteArray = new int[list.size()];
    for (int i = 0; i < whiteArray.length; i++) {
      whiteArray[i] = list.get(i);
      System.out.print(whiteArray[i] + " ");
    }

    System.out.println("------");
    System.out.println(BinarySearch.indexOf(whiteArray, key));
  }
}
