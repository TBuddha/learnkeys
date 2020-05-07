package com.zhout.c10简化函数调用.p4将查询函数和修改函数分离;

/**
 * @author zhout
 * @date 2020/4/29 16:05
 */
class Before {

  // 有这样一个函数:一旦有人入侵安全系统，它会吿诉我入侵者的名字，并发送一个瞥报。
  // 如果入侵者不止一个，也只发送一条警报:
  String foundMiscreant(String[] people) {
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
  // 该函数被下列代码调用
  void checkSecurity(String[] people) {
    String found = foundMiscreant(people);
    // 其他代码
    someLaterCode(found);
  }

  void sendAlert() {}

  void someLaterCode(String arg) {}
}
