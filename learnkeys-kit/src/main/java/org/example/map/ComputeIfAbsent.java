package org.example.map;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author zhout
 * @date 2021/2/24 09:20
 */
public class ComputeIfAbsent {

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

    String res = map.computeIfAbsent(tenantCode, k -> "dd");
    System.out.println(res);
    System.out.println(map);
  }
}
