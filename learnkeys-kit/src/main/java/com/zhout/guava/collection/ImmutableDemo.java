package com.zhout.guava.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * @author zhout
 * @date 2020/4/7 15:10
 */
class ImmutableDemo {
  public static void main(String[] args) {
    /*
    创建不可变集合方法：
        copyOf方法，如ImmutableSet.copyOf(set);
        of方法，如ImmutableSet.of(“a”, “b”, “c”)或 ImmutableMap.of(“a”, 1, “b”, 2);
        Builder工具
     */
    ImmutableSet<String> set = ImmutableSet.of("a", "b", "c", "d");
    ImmutableSet<String> set1 = ImmutableSet.copyOf(set);
    ImmutableSet<String> set2 = ImmutableSet.<String>builder().addAll(set).add("e").build();
    System.out.println(set);
    ImmutableList<String> list = set.asList();
  }
}
