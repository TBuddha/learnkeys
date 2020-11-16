package org.example.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author zhout
 * @date 2020/11/16 10:55
 */
public class OptionalExam {

  /** 对象创建 */
  public void ex1() {
    // 第一种 创建一个包装对象值为空的Optional对象 一般不使用
    Optional<String> optStr = Optional.empty();
    // 第二种 创建包装对象值非空的Optional对象
    Optional<String> optStr1 = Optional.of("optional");
    // 第三种 创建包装对象值允许为空的Optional对象
    Optional<String> optStr2 = Optional.ofNullable(null);
  }

  /** map */
  @Test
  public void testMap() {
    // 第二种 创建包装对象值非空的Optional对象
    Optional<String> optStr1 = Optional.of(" 测试 map 方法数据");

    /// 获取 optStr1 中的值
    Optional<String> stringOptional = optStr1.map((value) -> value);
    /// optStr1 有值 所以输出的是  optStr1
    System.out.println(stringOptional.orElse("orElse输出的内容"));
  }

  /** orElse、orElseGet、orElseThrow */
  @Test
  public void testOrElse() {
    // 第一种 创建一个包装对象值为空的Optional对象
    Optional<String> optStr = Optional.empty();
    // optStr 无值 所以输出的是 orElse中的内容 "测试 orElse  "
    // orElse 方法接收的参数是字符串
    System.out.println("测试1  " + optStr.orElse("测试 orElse"));

    // orElseGet 方法接收的是一个函数方法
    System.out.println("测试2  " + optStr.orElseGet(() -> getStr()));

    // orElseGet 方法接收的是一个函数方法 返回值是一个 Throwable
    System.out.println("测试3  " + optStr.orElseThrow(() -> new IllegalArgumentException("空值")));
  }

  private String getStr() {
    return "测试 orElseGet";
  }

  @Test
  public void testOrElse2() {
    // 第二种 创建包装对象值非空的Optional对象
    Optional<String> optStr1 = Optional.of("optional");
    /// optStr1 有值 所以输出的是  optional
    System.out.println(optStr1.orElse("orElse输出的内容"));
  }
}
