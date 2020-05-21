package com.zhout.SOLID.接口隔离原则;

/**
 * 什么是Role interface? 举个例子，砖头(Brick)可以被建筑工人用来盖房子，也可以被用来正当防卫：
 *
 * @author zhout
 * @date 2020/5/21 10:08
 */
class Brick {
  private int length;
  private int width;
  private int height;
  private int weight;

  public void build() {
    // ...包工队盖房
  }

  public void defense() {
    // ...正当防卫
  }
}

/** 1.如果直接提取以下接口，这就是Header Interface： */
interface BrickInterface {

  void buildHouse();

  void defense();
}

/**
 * 2.普通大众需要的是可以防卫的武器，并不需要用砖盖房子。
 * 当普通大众(Person)被迫依赖了自己不需要的接口方法时，就违反接口隔离原则。
 * 正确的做法是站在消费者的角度，抽象出Role interface:
 */
interface BuildHouse {
  void build();
}

interface StrikeCompetence {
  void defense();
}

class Brick2 implements BuildHouse, StrikeCompetence {
  @Override
  public void build() {}

  @Override
  public void defense() {}
}

/** 有了Role interface，作为消费者的普通大众和建筑工人就可以分别消费自己的接口：*/
// Worker.java
// brick.build();

// Person.java
// brick.strike();
