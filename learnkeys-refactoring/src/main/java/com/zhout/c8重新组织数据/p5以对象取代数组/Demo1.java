package com.zhout.c8重新组织数据.p5以对象取代数组;

/**
 * @author zhout
 * @date 2020/4/20 16:51
 */
public class Demo1 {

  public void array() {
    // 我们的范例从一个数组开始，其中有三个元素，分别保存一支球队的名称、获胜场 次和失利场次。这个数组的声明可能像这样
    String[] row = new String[3];

    // 客户端代码可能像这样
    row[0] = "Liverpool";
    row[1] = "15";
    String name = row[0];
    int wins = Integer.parseInt(row[1]);
  }

  //  public void array1() {
  //    // 现在，我要找到创建和访问数组的地方。在创建地点，我将它替换为下列代码：
  //    Performance row = new Performance();
  //
  //    // 对于数组使用地点，我将它替换为以下代码
  //    row._data[0] = "Liverpool";
  //    row._data[1] = "15";
  //    String name = row._data[0];
  //    int wins = Integer.parseInt(row._data[1]);
  //  }

  //  public void array2() {
  //    Performance row = new Performance();
  //    // 然后修改row对象的用户，让他们改用「取值丨设值函数」来访问球队名称：
  //    row.setName("Liverpool");
  //    row._data[1] = "15";
  //    String name = row.getName();
  //    int wins = Integer.parseInt(row._data[1]);
  //  }

  public void array3() {
    Performance row = new Performance();
    row.setName("Liverpool");
    row.setWins("15");
    String name = row.getName();
    int wins = row.getWins();
  }
}

// 为了将数组变成对象，我首先建立一个对应的class：
class Performance {

  // 然后为它声明一个public值域，用以保存原先数组。〔我知道public值域十恶不赦，请放心，稍后我便让它改邪归正
  // public String[] _data = new String[3];

  // 处理完所有元素之后，我就可以将保存该数组的值域声明为private了。
  private String[] _data = new String[3];

  // 然后我要逐一为数组元素加上有意义的取值/设值函数（getter/setter）。首先从「球队名称」开始：
  public String getName() {
    return _data[0];
  }

  public void setName(String arg) {
    _data[0] = arg;
  }

  // 第二个元素也如法炮制。为了简单起见，我还可以把数据型别的转换也封装起来：
  public int getWins() {
    return Integer.parseInt(_data[1]);
  }

  public void setWins(String arg) {
    _data[1] = arg;
  }
}
