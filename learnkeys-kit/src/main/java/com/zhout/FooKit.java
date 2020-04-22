package com.zhout;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author zhout
 * @date 2020/4/20 15:23
 */
public class FooKit {

  @Test
  public void listClearNull() {
    List<Integer> list = Lists.newArrayList();
    list.add(1);
    list.add(null);
    list.add(3);
    list.add(4);
    list.add(null);
    list.removeAll(Collections.singleton(null));
    System.out.println(list);
  }
}
