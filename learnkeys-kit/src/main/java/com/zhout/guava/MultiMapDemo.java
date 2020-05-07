package com.zhout.guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;

/**
 * @author zhout
 * @date 2020/4/7 15:12
 */
class MultiMapDemo {
  public static void main(String[] args) {
    // Multimap可以很容易地把一个键映射到多个值。换句话说，Multimap是把键映射到任意多个值的一般方式。
    Multimap<String, Integer> map = HashMultimap.create(); // Multimap是把键映射到任意多个值的一般方式
    map.put("a", 1); // key相同时不会覆盖原value
    map.put("a", 1);
    map.put("a", 3);

    System.out.println(map); // {a=[1, 2, 3]}
    System.out.println(map.get("a")); // 返回的是集合
    System.out.println(map.size()); // 返回所有”键-单个值映射”的个数,而非不同键的个数
    System.out.println(map.keySet().size()); // 返回不同key的个数
    Map<String, Collection<Integer>> mapView = map.asMap();
  }
}
