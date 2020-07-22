package c30优先使用泛型方法;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhoutao
 * @date 2020/3/6 14:44
 */
class SetUnion {

  public static Set union(Set s1, Set s2) {
    Set result = new HashSet(s1);
    result.addAll(s2);
    return result;
  }

  public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.addAll(s2);
    return result;
  }

  public static void main(String[] args) {
    Set<String> guys = Sets.newHashSet("Tom", "Dick", "Harry");
    Set<String> stooges = Sets.newHashSet("Larry", "Moe", "Curly");
    Set<String> aflCio = union2(guys, stooges);
    System.out.println(aflCio);
  }
}
