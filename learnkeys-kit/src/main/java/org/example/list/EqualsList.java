package org.example.list;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhout
 * @date 2021/2/23 15:24
 */
public class EqualsList {


  public static void main(String[] args) {
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();

    for (int i = 0; i < 10000; i++) {
      list1.add("test" + i);
      list2.add("test" + i * 2);
    }

    System.out.println(getDifferent(list1, list2));
    System.out.println(getDifferent2(list1, list2));
    System.out.println(getDifferent3(list1, list2));
    System.out.println(getDifferent4(list1, list2));

    //        判断两个List内的元素是否相同
    //        getDifferent total times    2514359
    //        false
    //        getDifferent2 total times      7563
    //        false
    //        getDifferent3 total times  26976244
    //        false
    //        getDifferent4 total times  37313357
    //        false
  }

  /**
   * 判断两个List内的元素是否相同
   */
  private static boolean getDifferent4(List<String> list1, List<String> list2) {
    long st = System.nanoTime();
    Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
    List<String> maxList = list1;
    List<String> minList = list2;
    if (list2.size() > list1.size()) {
      maxList = list2;
      minList = list1;
    }
    for (String string : maxList) {
      map.put(string, 1);
    }
    for (String string : minList) {
      Integer cc = map.get(string);
      if (cc != null) {
        map.put(string, ++cc);
        continue;
      }
      System.out.println("getDifferent4 total times " + (System.nanoTime() - st));
      return false;
    }
    System.out.println("getDifferent4 total times " + (System.nanoTime() - st));
    return true;
  }

  /**
   * 判断两个List内的元素是否相同
   */
  private static boolean getDifferent3(List<String> list1, List<String> list2) {
    long st = System.nanoTime();
    Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
    for (String string : list1) {
      map.put(string, 1);
    }
    for (String string : list2) {
      Integer cc = map.get(string);
      if (cc != null) {
        map.put(string, ++cc);
        continue;
      }
      System.out.println("getDifferent3 total times " + (System.nanoTime() - st));
      return false;
    }
    System.out.println("getDifferent3 total times " + (System.nanoTime() - st));
    return true;
  }

  /**
   * 判断两个List内的元素是否相同
   * 不过结论是retainAll方法的返回值：如果集合A数组的大小没有改变，则返回false。
   * 如果集合A和集合B是完全相同的集合，也会返回false。两个集合没有交集，才会返回true。
   * 简单来说，判断两个集合是否有交集，有则返回false，无则返回true（这句话不严谨）。
   * <p>
   * 还有为什么，我的注释上此方法用来判断两个List是否相同有bug，并不是说java这个方法有bug，
   * 而是我们直接使用来去判断两个list元素是否相同有bug，是由于List的contains()的方法导致的，
   * 这个demo中是List<String>，假如是List<Person>就会看到差别了。
   */
  private static boolean getDifferent2(List<String> list1, List<String> list2) {
    long st = System.nanoTime();
    System.out.println("getDifferent2 total times " + (System.nanoTime() - st));
    return !list1.retainAll(list2);
  }

  /**
   * 判断两个List内的元素是否相同
   */
  private static boolean getDifferent(List<String> list1, List<String> list2) {
    long st = System.nanoTime();
    if (list1.size() != list2.size()) {
      System.out.println("getDifferent total times " + (System.nanoTime() - st));
      return false;
    }
    for (String str : list1) {
      if (!list2.contains(str)) {
        System.out.println("getDifferent total times " + (System.nanoTime() - st));
        return false;
      }
    }
    System.out.println("getDifferent total times " + (System.nanoTime() - st));
    return true;
  }
}
