package com.zhout.c8重新组织数据.p5以对象取代数组;

/**
 * @author zhout
 * @date 2020/4/20 16:49
 */
public class Demo {

  public void array() {
    String[] row = new String[3];
    row[0] = "Liverpool";
    row[1] = "15";
  }
  // ==>
  //  Performance row = new Performance();
  //  row.setName("Liverpool");
  //  row.setWins("15");
}
