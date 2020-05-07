package com.zhout.guava;

import com.google.common.base.Optional;

/**
 * @author zhout
 * @date 2020/4/7 14:16
 */
class OptionalDemo {
  // Optional

  private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
    // isPresent():如果Optional包含非null的引用（引用存在），返回true
    System.out.println("First param is present: " + a.isPresent());
    System.out.println("Second param is present: " + b.isPresent());

    // 返回Optional所包含的引用,若引用缺失,返回指定的值
    Integer value1 = a.or(0);

    // 返回所包含的实例,它必须存在,通常在调用该方法时会调用isPresent()判断是否为null
    Integer value2 = b.get();
    return value1 + value2;
  }

  public static void main(String[] args) {
    Integer value1 = null;
    Integer value2 = 10;
    Optional<Integer> a = Optional.fromNullable(value1);
    Optional<Integer> b = Optional.of(value2);
    System.out.println(sum(a, b));
  }
}
