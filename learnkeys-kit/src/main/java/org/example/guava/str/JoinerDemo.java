package org.example.guava.str;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhout
 * @date 2020/4/7 14:39
 */
class JoinerDemo {

  public static void main(String[] args) {
    /*
    Joiner
    on:制定拼接符号，如：testDraw-synchronizedBlock-synchronizedMethod 中的 “-“ 符号
    skipNulls()：忽略NULL,返回一个新的Joiner实例
    useForNull(“Hello”)：NULL的地方都用字符串”Hello”来代替
    */
    StringBuilder sb = new StringBuilder();
    Joiner.on(",").skipNulls().appendTo(sb, "Hello", "guava");
    System.out.println(sb);

    System.out.println(Joiner.on(",").useForNull("none").join(1, null, 3));

    System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList(1, 2, 3, 4, null, 6)));

    Map<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    System.out.println(Joiner.on(",").withKeyValueSeparator("=").join(map));
  }
}
