package com.zhout.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhout
 * @date 2020/4/7 15:23
 */
class CallbackDemo {
  public static void main(String[] args) {
    /*
       ->是lambda表达式,就是匿名函数
       这是Java8里新加入的特性lambda表达式，相当于无名称的函数，
       最简单的例子是 Collections.sort(list, (x, y) -> y - x); 其中
       (x, y) -> y - x
       是一个lambda表达式，输入两个参数x, y，返回值 x - y。“->”起分隔作用。，Java会自动翻译
    */
    Cache<String, String> cache =
        CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(1, TimeUnit.SECONDS).build();
    try {
      String result = cache.get("java", () -> "hello java内置");
      System.out.println(result);
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}
