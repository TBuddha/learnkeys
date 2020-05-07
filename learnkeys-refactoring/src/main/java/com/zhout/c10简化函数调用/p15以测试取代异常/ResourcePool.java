package com.zhout.c10简化函数调用.p15以测试取代异常;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 下面的例子中，我以一个ResourcePool 对象管理「创建代价高昂、可复用」的资源（例如数据库连接，database connection）。这个对象带有两个「池」（pools），
 * 一个用以保存可用资源，一个用以保存已分配资源。当用户索求一份资源时，ResourcePool 对象从「可用资源池』中取出一份资源交出，并将这份资源转移到
 * 「已分配资源池」。当用户释放一份资源时，ResourcePool 对象就将该资源从「已 分配资源池」放回「可用资源池」。
 * 如果「可用资源池」不能满足用户的索求，ResourcePool对象就创建一份新资源。
 *
 * @author zhout
 * @date 2020/5/7 14:45
 */
class ResourcePool {

  Stack _available; // 可用的
  Stack _allocated; // 可分配的

  Resource getResource() {
    Resource result;
    try {
      result = (Resource) _available.pop();
      _allocated.push(result);
      return result;
    } catch (EmptyStackException e) {
      result = new Resource();
      _allocated.push(result);
      return result;
    }
  }

  // 在这里，「可用资源用尽」并不是一种意料外的事件，因此我不该使用异常 （exceptions）表示这种情况。
  // 为了去掉这里的异常，我首先必须添加一个适当的提前测试，并在其中处理「可用 资源池为空」的情况：
  Resource getResource1() {
    Resource result;
    if (_available.isEmpty()) {
      result = new Resource();
      _allocated.push(result);
      return result;
    } else {
      try {
        result = (Resource) _available.pop();
        _allocated.push(result);
        return result;
      } catch (EmptyStackException e) {
        result = new Resource();
        _allocated.push(result);
        return result;
      }
    }
  }

  // 现在getResource() 应该绝对不会抛出异常了。我可以添加assertion 保证这一点：
  Resource getResource2() {
    Resource result;
    if (_available.isEmpty()) {
      result = new Resource();
      _allocated.push(result);
      return result;
    } else {
      try {
        result = (Resource) _available.pop();
        _allocated.push(result);
        return result;
      } catch (EmptyStackException e) {
        Assert.shouldNeverReachHere("available was empty on pop");
        result = new Resource();
        _allocated.push(result);
        return result;
      }
    }
  }

  // 如果一切运转正常，就可以将try 区段中的代码拷贝到try 区段之外，然后将区段全部移除
  Resource getResource3() {
    Resource result;
    if (_available.isEmpty()) {
      result = new Resource();
      _allocated.push(result);
      return result;
    } else {
      result = (Resource) _available.pop();
      _allocated.push(result);
      return result;
    }
  }

  // 在这之后我常常发现，我可以对条件代码（conditional code）进行整理。本例之中我可以
  // 使用Consolidate Duplicate Conditional Fragments(合并重复条件判断)
  Resource getResource4() {
    Resource result;
    if (_available.isEmpty()) result = new Resource();

    else result = (Resource) _available.pop();
    _allocated.push(result);

    return result;
  }
}
