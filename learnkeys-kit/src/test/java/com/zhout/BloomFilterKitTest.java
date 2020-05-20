package com.zhout;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhout
 * @date 2020/5/20 15:54
 */
public class BloomFilterKitTest {

  @Test
  public void demo() {
    int a = 1, b = 2;
    BloomFilterKit bloomFilterKit = new BloomFilterKit();
    bloomFilterKit.add(a);
    bloomFilterKit.add(b);

    Assert.assertTrue(bloomFilterKit.contains(1));
  }

  @Test
  public void demo2() {
    String a = "国", b = "人";
    BloomFilterKit bloomFilterKit = new BloomFilterKit();
    bloomFilterKit.add(a);
    bloomFilterKit.add(b);
    Assert.assertTrue(bloomFilterKit.contains("人"));
  }

  @Test
  public void demo3() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    BloomFilterKit bloomFilterKit = new BloomFilterKit();
    bloomFilterKit.add(list);
    // NO
    Assert.assertTrue(bloomFilterKit.contains(1));
  }

  @Test
  public void demo4() {
    BloomFilterKit bloomFilterKit = new BloomFilterKit();
    bloomFilterKit.add("1");
    bloomFilterKit.add(1);
    bloomFilterKit.add(0.0);
    bloomFilterKit.add(false);

    Assert.assertTrue(bloomFilterKit.contains("1"));
    Assert.assertTrue(bloomFilterKit.contains(0.0));
    Assert.assertTrue(bloomFilterKit.contains(false));
  }
}
