package com.zhout.c8重新组织数据.p10封装值域;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhout
 * @date 2020/4/22 16:07
 */
public class Demo {

  // public String name;

  // 将它声明为private，并提供相应的访问函数==>

  @Setter @Getter private String name;
}
