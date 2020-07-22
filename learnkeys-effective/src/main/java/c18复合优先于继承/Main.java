package c18复合优先于继承;

import java.util.*;

/**
 * @author zhoutao
 * @date 2019/12/25 10:08
 */
public class Main {

  public static void main(String[] args) {
    Set<Compare> times = new InstrumentedSet<>(new TreeSet<>(Collections.singleton(new Compare())));
    Set<Integer> set = new InstrumentedSet<>(new HashSet<>(16));
  }

  public static class Compare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      return 0;
    }
  }
}
