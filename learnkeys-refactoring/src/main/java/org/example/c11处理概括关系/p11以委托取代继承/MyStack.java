package org.example.c11处理概括关系.p11以委托取代继承;

import java.util.Vector;

/**
 * @author zhout
 * @date 2020/5/12 14:29
 */
class MyStack extends Vector {

  // 2. 我开始修改MyStack 的函数，让它们使用委托关系。首先从push() 开始：
  public void push(Object element) {
    // insertElementAt(element, 0);
    _vector.insertElementAt(element, 0);
  }

  // 3.现在轮到pop
  public Object pop() {
    //    Object result = firstElement();
    //    removeElementAt(0);
    //    return result;
    Object result = _vector.firstElement();
    _vector.removeElementAt(0);
    return result;
  }

  // 1.首先，我要在中新建一个值域，用以保存「受托之Vector 对象」。
  // 一开始我把这个值域初始化为this，这样在重构进行过程中，我就可以同时使用继承和委托
  // private Vector _vector = this;

  // 4.修改完所有subclass 函数后，我可以打破与superclass 之间的联系了 ：
  private Vector _vector = new Vector();

  // 5.然后，对于Stack 客户端可能用到的每一个Vector 函数（译注：这些函数原本是继承而来的），我都必须在中添加一个简单的请托函数（delegating method）：
  public int size() {
    return _vector.size();
  }

  public boolean isEmpty() {
    return _vector.isEmpty();
  }

  // ---- 在我可以编译并测试。如果我忘记加入某个请托函数，编译器会告诉我。----//
}
