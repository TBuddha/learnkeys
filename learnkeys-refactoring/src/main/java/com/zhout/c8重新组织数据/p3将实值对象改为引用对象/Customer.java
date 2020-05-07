package com.zhout.c8重新组织数据.p3将实值对象改为引用对象;

import com.google.common.collect.Maps;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhout
 * @date 2020/4/20 15:28
 */
class Customer {

  private final String _name;

  public String getName() {
    return _name;
  }

  /**
   * 1、首先我使用 Replace Constructor with Factory Method。 这样，我就可以控制Customer对象的创建过程，这在以后会是非常重要的。
   * 我在Customer class中定义这个factory method
   */
  //  public static Customer create(String name) {
  //    return new Customer(name);
  //  }

  /** 2、修改factory method，让它返回预先创建好的Customer对象 */
  //  public static Customer create(String name) {
  //    return (Customer) _instances.get(name);
  //  }

  /** 3、由于create()总是返回既有的Customer对象，所以我应该使用Rename Method 修改这个factory method的名称，以便强调（说明）这一点 */
  public static Customer getNamed(String name) {
    return (Customer) _instances.get(name);
  }

  // 把构造函数声明为private
  private Customer(String name) {
    _name = name;
  }

  /** 详情请看第8章第3节 注：这种实现已经过时了,如今更推荐ConcurrentHashMap */
  // private static Dictionary _instances = new Hashtable();
  private static Map<String, Customer> _instances = Maps.newConcurrentMap();

  static void loadCustomers() {
    new Customer("Lemon Car Hire").store();
    new Customer("Associated Coffee Machines").store();
    new Customer("Bilston Gasworks").store();
  }

  private void store() {
    _instances.put(this.getName(), this);
  }
}
