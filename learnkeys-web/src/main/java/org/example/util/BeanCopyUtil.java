package org.example.util;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @date 2020/10/13
 */
public class BeanCopyUtil extends BeanUtils {

  @FunctionalInterface
  public interface BeanCopyUtilCallBack<S, T> {

    /** 定义默认回调方法
     * 这里可以定义特定的转换规则
     * 因为属性不同的字段无法拷贝，如Integer sex,String sex。
     * 可利用回调方法实现自定义转换。
     */
    void callBack(S t, T s);
  }
  /**
   * 集合数据的拷贝
   *
   * @param sources: 数据源类
   * @param target: 目标类::new(eg: UserVO::new)
   */
  public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
    return copyListProperties(sources, target, null);
  }

  /**
   * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
   *
   * @param sources: 数据源类
   * @param target: 目标类::new(eg: UserDo::new)
   * @param callBack: 回调函数
   */
  public static <S, T> List<T> copyListProperties(
          List<S> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
    List<T> list = new ArrayList<>(sources.size());
    for (S source : sources) {
      T t = target.get();
      copyProperties(source, t);
      list.add(t);
      if (callBack != null) {
        // 回调
        callBack.callBack(source, t);
      }
    }
    return list;
  }


























  public static void main(String[] args) {

    List<UserDO> list = Lists.newArrayList(new UserDO("阿强", 1), new UserDO("阿美", 2));
    System.out.println(BeanCopyUtil.copyListProperties(list, UserVO::new));

    System.out.println("-------------------");

    List<UserVO> resList =
        BeanCopyUtil.copyListProperties(
            list,
            UserVO::new,
            (userDO, userVO) -> {
              // 定义特定的转换规则
              userVO.setSex(Sex.valueOf(userDO.getSex()).getDesc());
            });
    System.out.println(resList);
  }

  @Data
  @AllArgsConstructor
  private static class UserDO {
    private String name;
    private Integer sex;
  }

  @Data
  private static class UserVO {
    private String name, sex;
  }

  @Getter
  @AllArgsConstructor
  private enum Sex {
    UNKNOW("未知", 0),
    MEN("男生", 1),
    WOMAN("女生", 2);

    private String desc;

    private Integer code;

    public static Sex valueOf(Integer code) {
      return Stream.of(values()).filter(type -> type.getCode().equals(code)).findAny().orElse(null);
    }
  }
}
