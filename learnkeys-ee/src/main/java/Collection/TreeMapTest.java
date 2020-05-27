package Collection;

import java.util.TreeMap;

/**
 * @author zhoutao
 * @date 2019/6/20 17:32
 * R类，重写了equals方法，如果count属性相等返回true 重写了compareTo(Object obj)方法，如果count属性相等返回0;
 */
class R implements Comparable {
  private int count;

  R(int count) {
    this.count = count;
  }

  public String toString() {
    return "R(count属性:" + count + ")";
  }

  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj != null && obj.getClass() == R.class) {
      R r = (R) obj;
      if (r.count == this.count) {
        return true;
      }
    }
    return false;
  }

  public int compareTo(Object obj) {
    R r = (R) obj;
    if (this.count > r.count) {
      return 1;
    } else if (this.count == r.count) {
      return 0;
    } else {
      return -1;
    }
  }
}

public class TreeMapTest {
  public static void main(String[] args) {
    TreeMap tm = new TreeMap();
    tm.put(new R(3), "测试A");
    tm.put(new R(-5), "测试B");
    tm.put(new R(9), "测试C");
    System.out.println(tm);
    // 返回该TreeMap的第一个Entry对象
    System.out.println(tm.firstEntry());
    // 返回该TreeMap的最后一个key值
    System.out.println(tm.lastKey());
    // 返回该TreeMap的比new R(2)大的最小key值。
    System.out.println(tm.higherKey(new R(2)));
    // 返回该TreeMap的比new R(2)小的最大的key－value对。
    System.out.println(tm.lowerEntry(new R(2)));
    // 返回该TreeMap的子TreeMap
    System.out.println(tm.subMap(new R(-1), new R(4)));
  }
}
