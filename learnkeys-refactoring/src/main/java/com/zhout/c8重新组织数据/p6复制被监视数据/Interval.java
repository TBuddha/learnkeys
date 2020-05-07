package com.zhout.c8重新组织数据.p6复制被监视数据;

import java.util.Observable;

/**
 * @author zhout
 * @date 2020/4/21 10:17
 */
class Interval extends Observable {

  // 在domain class 中加入 _end 值域：
  private String _end = "0";

  // 这里，我给它的初值和GUI class 给它的初值是一样的。然后我再加入取值/设值（getter/setter）
  String getEnd() {
    return _end;
  }

  void setEnd(String arg) {
    _end = arg;
    setChanged();
    notifyObservers(); // 译注：notification code
  }
  // 由于使用了Observer 模式，我必须在设值函数（setter）中加上「发出通告」动作 （即所谓notify code ）。
  // 我把_end声明为一个字符串，而不是一个看似更合理的整数，这是因为我希望将修改量减至最少。
  // 将来成功复制数据完毕后，我可以自由自在地于domain class 内部把_end 声明为整数。
  // ------------------------------------------------------------------//
}
