package io.charset;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * @author zhouT
 * @date 2018/12/26 19:33
 */
public class CharsetTest {
  public static void main(String[] args) {
    SortedMap<String, Charset> map = Charset.availableCharsets();
    for (String alias : map.keySet()) {
      System.out.println(alias + "--->" + map.get(alias));
    }
  }
}
