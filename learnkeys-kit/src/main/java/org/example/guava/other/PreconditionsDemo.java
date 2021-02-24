package org.example.guava.other;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhout
 * @date 2020/9/16 10:38
 */
public class PreconditionsDemo {

  @Test
  public void Preconditions() throws Exception {

    getPersonByPrecondition(8, "peida");

    try {
      getPersonByPrecondition(-9, "peida");
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      getPersonByPrecondition(8, "");
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      getPersonByPrecondition(8, null);
    } catch (Exception e) {
      System.out.println(e);
    }

    List<Integer> intList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      try {
        checkState(intList, 9);
        intList.add(i);
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    try {
      checkPositionIndex(intList, 3);
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      checkPositionIndex(intList, 13);
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      checkPositionIndexes(intList, 3, 7);
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      checkPositionIndexes(intList, 3, 17);
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      checkPositionIndexes(intList, 13, 17);
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      checkElementIndex(intList, 6);
    } catch (Exception e) {
      System.out.println(e);
    }

    try {
      checkElementIndex(intList, 16);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void getPersonByPrecondition(int age, String name) throws Exception {
    com.google.common.base.Preconditions.checkNotNull(name, "name为null");
    com.google.common.base.Preconditions.checkArgument(name.length() > 0, "name为\'\'");
    com.google.common.base.Preconditions.checkArgument(age > 0, "age 必须大于0");
    System.out.println("it's ok, a person age:" + age + ",name:" + name);
  }

  public static void checkState(List<Integer> intList, int index) throws Exception {
    // 表达式为true不抛异常
    com.google.common.base.Preconditions.checkState(intList.size() < index, " intList size 不能大于" + index);
  }

  public static void checkPositionIndex(List<Integer> intList, int index) throws Exception {
    com.google.common.base.Preconditions.checkPositionIndex(
        index, intList.size(), "index " + index + " 不在 list中， List size为：" + intList.size());
  }

  public static void checkPositionIndexes(List<Integer> intList, int start, int end)
      throws Exception {
    com.google.common.base.Preconditions.checkPositionIndexes(start, end, intList.size());
  }

  public static void checkElementIndex(List<Integer> intList, int index) throws Exception {
    com.google.common.base.Preconditions.checkElementIndex(
        index, intList.size(), "index 为 " + index + " 不在 list中， List size为： " + intList.size());
  }
}
