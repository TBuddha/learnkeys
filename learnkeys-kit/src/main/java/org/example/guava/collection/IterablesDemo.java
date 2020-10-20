package org.example.guava.collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhout
 * @date 2020/4/7 15:14
 */
class IterablesDemo {
  public static void main(String[] args) {
    // Iterables.find查找集合首个匹配的元素
    List<String> listStr = Lists.newArrayList("hello", "world", "hehe");

    // 查找首个以h开头的值
    String value =
        Iterables.find(
            listStr,
            new Predicate<String>() {
              @Override
              public boolean apply(String input) {
                return input.startsWith("h");
              }
            });
    System.out.println(value);

    // 在Java 8中的实现为
    String value2 = listStr.stream().findFirst().filter(input -> input.startsWith("h")).get();
    System.out.println("value2-->" + value2);
  }
}
