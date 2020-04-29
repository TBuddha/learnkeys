package com.zhout.c9简化条件表达式.p7引入空对象;

/**
 * —家公用事业公司的系统以Site 表示地点（场所）。庭院宅等和集合公寓（apartment）都使用该公司的服务。 任何时候每个地点都拥有（或说都对应于）一个顾客，顾客信息以Customer
 * 表示：
 *
 * @author zhout
 * @date 2020/4/28 14:54
 */
class Site {

  Customer _customer;

  //  Customer getCustomer() {
  //    return _customer;
  //  }
  // =>
  // 接下来的部分稍微有点麻烦。对于所有「返回null」的地方，我都要将它改为「返回null object」，
  // 此外我还要把foo==null这样的检查替换成foo.isNull()。我发现下列办法很有用：查找所有「索求Customer 对象」的地方，将它们都加以修改,
  // 使它们不能返回null ，改而返回一个NullCustomer 对象
  Customer getCustomer() {
    return (_customer == null) ? Customer.newNull() : _customer;
  }
}
