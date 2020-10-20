package org.example.c6重新组织函数.p6剖解临时变量;

/**
 * 译注：苏格兰布丁（haggis）是一种苏格兰菜，把羊心等内脏装在羊胃里煮成。由于
 * 它被羊胃包成一个球体，因此可以像球一样踢来踢去，这就是本例的由来。「把羊心装在羊胃里煮成…」，呃，有些人难免对这道菜恶心，Martin Fowler想必是其中之一。
 *
 * @author zhout
 * @date 2020/4/14 10:27
 */
class Haggis {

  private double _primaryForce = 8.0; // 初始力

  private double _mass = 4.0; // 质量

  private int _delay = 6; // 延迟

  private double _secondaryForce = 16.0; // 二次力

  // 下面范例中我要计算一个苏格兰布丁（haggis）运动的距离。在起点处，静止的苏格兰布丁会受到一个初始力的作用而开始运动。
  // 一段时间后，第二个力作用于布丁，让它再次加速。根据牛顿第二定律，我可以这样计算布丁运动的距离：
  double getDistanceTravelled(int time) {
    double result;
    double acc = _primaryForce / _mass; // 译注：第一次赋值处

    int primaryTime = Math.min(time, _delay);
    result = 0.5 * acc * primaryTime * primaryTime;

    int secondaryTime = time - _delay;
    if (secondaryTime > 0) {
      double primaryVel = acc * _delay; // 以下是第二次赋值处
      acc = (_primaryForce + _secondaryForce) / _mass;
      result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
    }
    return result;
  }

  //首先，在函数开始处修改这个临时变量的名称，并将新的临时变量声明为final。
  // 接下来我把第二次赋值之前对acc变量的所有引用点，全部改用新的临时变量。
  // 最后，我在第二次赋值处重新声明acc变量
  double getDistanceTravelled1(int time) {
    double result;
    final double primaryAcc = _primaryForce / _mass;

    int primaryTime = Math.min(time, _delay);
    result = 0.5 * primaryAcc * primaryTime * primaryTime;

    int secondaryTime = time - _delay;
    if (secondaryTime > 0) {
      double primaryVel = primaryAcc * _delay;
      double acc = (_primaryForce + _secondaryForce) / _mass;
      result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
    }
    return result;
  }

  //继续处理临时变量的第二次赋值。这次我把原先的临时变量完全删掉，
  // 代之以一个新的临时变量。新变量的名称指出，它只承担原先变量的第二个责任：
  double getDistanceTravelled2(int time) {
    double result;
    final double primaryAcc = _primaryForce / _mass;

    int primaryTime = Math.min(time, _delay);
    result = 0.5 * primaryAcc * primaryTime * primaryTime;

    int secondaryTime = time - _delay;
    if (secondaryTime > 0) {
      double primaryVel = primaryAcc * _delay;
      final double secondaryAcc = (_primaryForce + _secondaryForce) / _mass;
      result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
    }
    return result;
  }
}
