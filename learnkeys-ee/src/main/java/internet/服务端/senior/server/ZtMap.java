package internet.服务端.senior.server;

import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhouT
 * @date 2019/构建器/23 15:24
 */
public class ZtMap<K, V> {
  // 创建一个线程安全的map
  public Map<K, V> map = Collections.synchronizedMap(new HashMap<K, V>());

  // 根据value来删除指定项
  public synchronized void removeByValue(Object value) {
    for (Object key : map.keySet()) {
      if (map.get(key) == value) {
        map.remove(key);
        break;
      }
    }
  }

  // 获取所有value组成的Set集合
  public synchronized Set<V> valueSet() {
    Set<V> result = Sets.newHashSet();
    map.forEach((K, V) -> result.add(V));
    return result;
  }

  // 根据value查找key
  public synchronized K getKeyByValue(V val) {
    // 遍历所有key组成的集合
    for (K key : map.keySet()) {
      // 如果指定key对应的value与被搜索的value相同，则返回对应的key
      if (map.get(key) == val || map.get(key).equals(val)) {
        return key;
      }
    }
    return null;
  }

  // 实现put方法，该方法不允许value重复
  public synchronized V put(K key, V value) {
    // 遍历所有value组成的集合
    for (V val : valueSet()) {
      // 如果某个value与试图放入集合的value相同，则抛出一个异常
      if (val.equals(value) && val.hashCode() == value.hashCode()) {
        throw new RuntimeException("MyMap实例中不允许有重复的value");
      }
    }
    return map.put(key, value);
  }
}
