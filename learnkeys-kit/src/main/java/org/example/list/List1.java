package org.example.list;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sun.istack.internal.Nullable;

import java.util.*;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/4/7 15:12
 */
class List1 {

  /**
   * 集合操作：交集、差集、并集
   */
  public static void main(String[] args) {
    Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
    Set<Integer> set2 = Sets.newHashSet(3, 4, 5, 6);
    Sets.SetView<Integer> inter = Sets.intersection(set1, set2); // 交集
    System.out.println(inter);

    Sets.SetView<Integer> diff = Sets.difference(set1, set2); // 差集,在A中不在B中
    System.out.println(diff);

    Sets.SetView<Integer> union = Sets.union(set1, set2); // 并集
    System.out.println(union);

    List<String> list = Lists.newArrayList("1","a");
    System.out.println(Arrays.toString(list.toArray(new String[0])));
  }
}
