package org.example.c9简化条件表达式.p4移除控制标记;

/**
 * @author zhout
 * @date 2020/4/26 18:28
 */
class ReturnDemo {

  void sendAlert() {}

  void someLaterCode(String found) {}

  // 本项重构的另一种形式将使用return 语句。为了阐述这种用法，我把前面的例子稍加修改，以控制标记记录搜索结果：
  void checkSecurity(String[] people) {
    String found = "";
    for (int i = 0; i < people.length; i++) {
      if (found.equals("")) {
        if (people[i].equals("Don")) {
          sendAlert();
          found = "Don";
        }
        if (people[i].equals("John")) {
          sendAlert();
          found = "John";
        }
      }
    }
    someLaterCode(found);
  }

  // 在这里，变量found 做了两件事：它既是控制标记，也是运算结果。遇到这种情况，我喜欢先把计算found 变量的代码提炼到一个独立函数中：
  void checkSecurity2(String[] people) {
    String found = foundMiscreant(people);
    someLaterCode(found);
  }

  String foundMiscreant(String[] people) {
    String found = "";
    for (int i = 0; i < people.length; i++) {
      if (found.equals("")) {
        if (people[i].equals("Don")) {
          sendAlert();
          // found = "Don";
          // 然后以return 语句取代控制标记
          return "Don";
        }
        if (people[i].equals("John")) {
          sendAlert();
          found = "John";
        }
      }
    }
    return found;
  }

  // 最后完全去掉控制标记：
  String foundMiscreant2(String[] people) {
    for (int i = 0; i < people.length; i++) {
      if (people[i].equals("Don")) {
        sendAlert();
        return "Don";
      }
      if (people[i].equals("John")) {
        sendAlert();
        return "John";
      }
    }
    return "";
  }
}
