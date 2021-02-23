package org.example.nullpoint;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author zhout
 * @date 2021/2/15 20:45
 */
public final class NullWrapper<T> {

  /**
   * 实际值
   */
  private final T value;

  /**
   * 无参构造，默认包装null
   */
  private NullWrapper() {
    this.value = null;
  }

  /**
   * 有参构造器，用来包装外部传入的value
   */
  private NullWrapper(T value) {
    this.value = value;
  }

  /**
   * 静态方法，返回一个包装了null的Wrapper
   */
  public static <T> NullWrapper<T> empty() {
    //调用无参构造，返回包装了null的Wrapper
    System.out.println("由于value为null，直接返回包装了null的Wrapper，让流程继续往下");
    return new NullWrapper<>();
  }

  /**
   * 静态方法，返回一个包装了value的Wrapper (value可能为null)
   */
  public static <T> NullWrapper<T> ofNullable(T value) {//调用有参构造，返回包装了value的Wrapper
    return new NullWrapper<>(value);
  }

  /**
   * 核⼼⽅法：
   * 1.如果value为null，直接返回空的Wrapper
   * 2.如果value不为null，则使⽤mapper对value进⾏处理，往下剥⼀层（这是关键，⼀有机会就要往下剥一层，否则就是原地踏步）
   */
  public <U> NullWrapper<U> map(Function<? super T, ? extends U> mapper) {
    Objects.requireNonNull(mapper);
    if (value == null) {
      // 按上⾯说的，如果value为null，我都不处理了。但为了调⽤者拿到返回值后不会发⽣空
      return NullWrapper.empty();
    } else {
      /*
       * value不为null，那么就要想尽办法将它剥去⼀层⽪。
       * 由于此时value不为null，即使mapper的apply⽅法要做的操作是 value.getXxx()
       * mapper.apply(value)处理后的结果继续⽤Wrapper包装，此时【新的wrapper⾥的v
       * */
      return NullWrapper.ofNullable(mapper.apply(value));
    }

  }

  /**
   * 终端操作，决定勇敢⼀次。当你做好⾯对外⾯的世界时，就要卸下伪装：直接把value丢出去。
   * 但为了不祸害别⼈，给个备选值：other。当你确实是null时，返回other
   */
  public T orElse(T other) {
    return value != null ? value : other;
  }


}
