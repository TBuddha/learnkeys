package com.zhout;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  @Test
  public void computeIfAbsent() {
    Map<String, String> map = new HashMap<>();
    String tenantCode = "1600";

    String a = map.get(tenantCode);
    if (a == null) {
      a = "dd";
      map.put(tenantCode, a);
    }
    System.out.println(map);

    String res = map.computeIfAbsent(tenantCode,k -> "dd");
    System.out.println(res);
    System.out.println(map);
  }
}
