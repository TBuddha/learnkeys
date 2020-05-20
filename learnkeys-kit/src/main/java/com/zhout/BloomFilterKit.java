package com.zhout;

import java.util.BitSet;

/**
 * 布隆过滤器
 * 使用场景
 * 1.判断给定数据是否存在：比如判断一个数字是否在于包含大量数字的数字集中（数字集很大，5亿以上！）、
 * 防止缓存穿透（判断请求的数据是否有效避免直接绕过缓存请求数据库）等等、邮箱的垃圾邮件过滤、黑名单功能等等。
 * 2.去重：比如爬给定网址的时候对已经爬取过的 URL 去重。
 *
 * guava实现的布隆过滤器
 * https://github.com/Snailclimb/JavaGuide/blob/master/docs/dataStructures-algorithms/data-structure/bloom-filter.md
 *
 * @author zhout
 * @date 2020/5/20 15:48
 */
class BloomFilterKit {
  /** 位数组的大小 */
  private static final int DEFAULT_SIZE = 2 << 24;
  /** 通过这个数组可以创建 6 个不同的哈希函数 */
  private static final int[] SEEDS = new int[] {3, 13, 46, 71, 91, 134};

  /** 位数组。数组中的元素只能是 0 或者 1 */
  private BitSet bits = new BitSet(DEFAULT_SIZE);

  /** 存放包含 hash 函数的类的数组 */
  private SimpleHash[] func = new SimpleHash[SEEDS.length];

  /** 初始化多个包含 hash 函数的类的数组，每个类中的 hash 函数都不一样 */
  public BloomFilterKit() {
    // 初始化多个不同的 Hash 函数
    for (int i = 0; i < SEEDS.length; i++) {
      func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
    }
  }

  /** 添加元素到位数组 */
  public void add(Object value) {
    for (SimpleHash f : func) {
      bits.set(f.hash(value), true);
    }
  }

  /** 判断指定元素是否存在于位数组 */
  public boolean contains(Object value) {
    boolean ret = true;
    for (SimpleHash f : func) {
      ret = ret && bits.get(f.hash(value));
    }
    return ret;
  }

  /** 静态内部类。用于 hash 操作！ */
  public static class SimpleHash {

    private int cap;
    private int seed;

    public SimpleHash(int cap, int seed) {
      this.cap = cap;
      this.seed = seed;
    }

    /** 计算 hash 值 */
    public int hash(Object value) {
      int h;
      return (value == null)
          ? 0
          : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
    }
  }
}
