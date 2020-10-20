package org.example.guava.collection;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sun.istack.internal.Nullable;

import java.util.*;

/**
 * @author zhout
 * @date 2020/4/7 15:12
 */
class ListDemo {
  public static void main(String[] args) {
    List<String> list = Lists.newArrayList();
    List<String> list2 = Lists.newArrayList("a", "b", "c");
    Set<Integer> set = Sets.newHashSet();
    System.out.println(list2);

    // 类型推导的功能，在Java 7中已经得到支持。
    Map<String, List<String>> m = new HashMap<>();
    // 可以返回原返回类型的任何子类型的对象
    Maps.newHashMap();
    Maps.newLinkedHashMap();

    // 集合转换、查找、过滤、分割
    // Lists.transform可以很方便将一个集合转换成另外一种类型的集合。
    List<String> listStr = Lists.newArrayList("1", "2", "3");
    // 将字符串集合转换为Integer集合
    List<Integer> listInteger =
        Lists.transform(
            listStr,
            new Function<String, Integer>() {
              @Nullable
              @Override
              public Integer apply(@Nullable String s) {
                return Integer.valueOf(s);
              }
            });
    System.out.println("listInteger-->" + listInteger);
  }
}
