package com.zhout.guava.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/9/16 16:37
 */
public class Maths {

  @Test
  public void test() {
    Assert.assertEquals(loga(2, 16), 4, 0);
    Assert.assertEquals(loga(3, 81), 4, 0);

    Assert.assertEquals(loga(-1, 81), Double.NaN, 0);
    Assert.assertEquals(loga(1, 81), Double.POSITIVE_INFINITY, 0);
  }

  /**
   * log_a N = x
   *
   * @param a 底数,a>0 && a!=1
   * @param N 真数
   * @return x,以a为底N的对数
   */
  public static double loga(int a, double N) {
    return Math.log(N) / Math.log(a); // Math.log的底为a
  }
}
