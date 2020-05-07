package com.zhout.c10简化函数调用.p4将查询函数和修改函数分离;

/**
 * @author zhout
 * @date 2020/4/29 15:52
 */
class After {

  // String foundMiscreant(String[] people) {

  // 3、所有调用都修改完毕后，就可以将修改函数改为void
  // void foundMiscreant(String[] people) {

  // 4、改个名称可能会更好些
  // void sendAlert(String[] people) {
  //    for (int i = 0; i < people.length; i++) {
  //      if (people[i].equals("Don")) {
  //        sendAlert();
  //        // return "Don";
  //        // return foundPerson(people);
  //        return;
  //      }
  //      if (people[i].equals("John")) {
  //        sendAlert();
  //        // return "John";
  //        // return foundPerson(people);
  //        return;
  //      }
  //    }
  //    //return "";
  // return foundPerson(people);
  // }

  // 5、当然，这种情况下，我得到了大量重复代码，因为修改函数之中使用了与查询函数相同的代码。
  // 现在我可以对修改函数实施Substitute Algorithm ，设法让它再简洁一些：
  void sendAlert(String[] people) {
    if (!foundPerson(people).equals("")) sendAlert();
  }

  // 2、现在，我要修改调用者，将原本的单一调用动作替换为两个调用，先调用修改函数，然后调用查询函数：
  void checkSecurity(String[] people) {
    //    (1)
    //    foundMiscreant(people);
    //    String found = foundPerson(people);
    //    someLaterCode(found);

    //(2)
    sendAlert(people);
    String found = foundPerson(people);
    someLaterCode(found);
  }

  // 1、为了将查询动作和修改动作分开，我首先建立一个适当的查询函数，使其与修改函数
  // 返回相同的值，但不造成任何副作用
  String foundPerson(String[] people) {
    for (int i = 0; i < people.length; i++) {
      if (people[i].equals("tDon")) {
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

  void sendAlert() {}

  void someLaterCode(String arg) {}
}
