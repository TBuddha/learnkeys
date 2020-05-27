package io.serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhouT
 * @date 2018/12/19 10:51
 */
@Setter
@Getter
@AllArgsConstructor
public class Teacher implements Serializable {

  private String name;
  private Person student;
}
