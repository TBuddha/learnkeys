package org.example.c8重新组织数据.p1自封装值域;

/**
 * 一旦你拥有一个subclass，上述所有动作的价值就体现出来了
 *
 * @author zhout
 * @date 2020/4/20 10:29
 */
class CappedRange extends IntRange {

  CappedRange(int low, int high, int cap) {
    super(low, high);
    _cap = cap;
  }

  private int _cap;

  int getCap() {
    return _cap;
  }

  /** 现在，我可以在CappedRange class中覆写getHigh()，从而加入对cap的考虑，而不必修改IntRange class的任何行为 */
  int getHigh() {
    return Math.min(super.getHigh(), getCap());
  }
}
