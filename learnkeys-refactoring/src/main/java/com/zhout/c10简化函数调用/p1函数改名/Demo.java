package com.zhout.c10简化函数调用.p1函数改名;

/**
 * @author zhout
 * @date 2020/4/29 15:13
 */
class Demo {

  Integer _officeAreaCode;

  Integer _officeNumber;

  // 以getTelephoneNumber()函数来取得某人的电话号码
  public String getTelephoneNumber() {
    return ("(" + _officeAreaCode + ")" + _officeNumber);
  }

  // 现在，我想把这个函数改名为getOfficeTelephoneNumber()。首先建立一个新函数 ，命名为getOfficeTelephoneNumber()， 并
  // 将原函数getTelephoneNumber()的代码复制过来。然后，让旧函数直接调用新函数:
  public String getOfficeTelephoneNumber() {
    return ("(" + _officeAreaCode + ")" + _officeNumber);
  }
}
