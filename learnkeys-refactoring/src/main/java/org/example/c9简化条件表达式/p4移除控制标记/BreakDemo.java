package org.example.c9简化条件表达式.p4移除控制标记;

/**
 * @author zhout
 * @date 2020/4/26 18:25
 */
class BreakDemo {

  void sendAlert() {}

  // 下列函数用来检查一系列人名之中是否包含两个可疑人物的名字（这两个人的名字硬编码于代码中〕
  void checkSecurity(String[] people) {
    boolean found = false;
    for (int i = 0; i < people.length; i++) {
      if (!found) {
        if (people[i].equals("Don")) {
          sendAlert();
          found = true;
        }
        if (people[i].equals("John")) {
          sendAlert();
          found = true;
        }
      }
    }
  }

  // 这种情况下很容易找出控制标记：当变量found 被赋予true 时，搜索就结束。我可以逐一引入break 语句：
  void checkSecurity1(String[] people) {
    boolean found = false;
    for (int i = 0; i < people.length; i++) {
      if (!found) {
        if (people[i].equals("Don")) {
          sendAlert();
          break;
        }
        if (people[i].equals("John")) {
          sendAlert();
          found = true;
        }
      }
    }
  }

  // 最后获得这样的成功
  void checkSecurity3(String[] people) {
    boolean found = false;
    for (int i = 0; i < people.length; i++) {
      if (!found) {
        if (people[i].equals("Don")) {
          sendAlert();
          break;
        }
        if (people[i].equals("John")) {
          sendAlert();
          break;
        }
      }
    }
  }

  // 然后我就可以把对控制标记的所有引用去掉：
  void checkSecurity4(String[] people) {
    for (int i = 0; i < people.length; i++) {
      if (people[i].equals("Don")) {
        sendAlert();
        break;
      }
      if (people[i].equals("John")) {
        sendAlert();
        break;
      }
    }
  }
}
