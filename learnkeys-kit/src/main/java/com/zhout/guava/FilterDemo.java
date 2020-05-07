package com.zhout.guava;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhout
 * @date 2020/4/7 15:15
 */
class FilterDemo {
  public static void main(String[] args) {
    // Collections2
    // filter(): 只保留集合中满足特定要求的元素
    List<String> list = Lists.newArrayList("moon", "dad", "refer", "son");
    Collection<String> palindromeList =
        Collections2.filter(
            list,
            input -> {
              assert input != null;
              return new StringBuilder(input).reverse().toString().equals(input); // 找回文串
            });
    System.out.println(palindromeList);

    // Collections2.filter过滤集合中所有符合特定条件的元素。
    List<String> listWithH2 =
        list.stream().filter(input -> input.startsWith("s")).collect(Collectors.toList());
    System.out.println("listWithH2-->" + listWithH2);
  }
}
