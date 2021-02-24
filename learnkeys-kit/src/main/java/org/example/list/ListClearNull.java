package org.example.list;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * @author zhout
 * @date 2021/2/24 09:19
 */
public class ListClearNull {

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
