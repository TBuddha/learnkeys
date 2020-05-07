package com.zhout.c10简化函数调用.p13封装向下转型动作;

/**
 * @author zhout
 * @date 2020/5/7 10:16
 */
class Client1 {

  public void test() {
    // 当我拥有一个群集时，上述那么做就很有意义。如果「保存Reading 对象」的群集被放在Site class 中，并且我看到了如下的代码（客户端）：
    // Reading lastReading = (Reading) theSite.readings().lastElement();

    // 我就可以不再把「向下转型」工作推给用户，并得以向用户隐藏群集：
    Reading lastReading = theSite.lastReading();
  }

  Site theSite;
}
