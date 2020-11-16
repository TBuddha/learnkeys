package org.example.optional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zhout
 * @date 2020/11/16 10:07
 */
@Getter
@AllArgsConstructor
public enum OptionalEnum {
  //
  UNSET("未设置", 0),
  MEN("男生", 1),
  WOMAN("女生", 2);

  private String desc;

  private Integer code;

  public static OptionalEnum valueOf(Integer code) {
    return Stream.of(values()).filter(sex -> sex.getCode().equals(code)).findAny().orElse(null);
  }

  public static OptionalEnum valueOf1(Integer code) {
    return Stream.of(values())
        .filter(sex -> sex.getCode().equals(code))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("can't not find this code"));
  }

  public static Optional<OptionalEnum> parse(String desc) {
    return Stream.of(values()).filter(sex -> sex.getDesc().equals(desc)).findAny();
  }

  public static void main(String[] args) {
    System.out.println(OptionalEnum.valueOf(4));
    //System.out.println(OptionalEnum.valueOf1(4));

    Optional<OptionalEnum> sex = OptionalEnum.parse("男生");
    if(sex.isPresent()){
      System.out.println("yes");
    }
  }
}
