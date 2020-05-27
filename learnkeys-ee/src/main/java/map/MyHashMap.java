package map;

import java.util.HashMap;

/**
 * @author zhouT
 * @date 2019/5/23 12:57
 */
public class MyHashMap extends HashMap {

  @Override
  public Object put(Object key, Object value) {
    // 如果已经存在key，不覆盖原有key对应的value
    if (!this.containsKey(key)) {
      return super.put(key, value);
    }
    return null;
  }
}
