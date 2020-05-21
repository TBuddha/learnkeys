package com.zhout.SOLID.里氏替换原则;

import java.time.Instant;

/**
 * 下例中，由于java.sql.Date不支持父类的toInstance方法，当父类被它替换时，程序无法正常运行，破坏了父类与调用方的契约，因此违反了里氏替换原则。
 *
 * @author zhout
 * @date 2020/5/21 09:42
 */
class Date extends java.sql.Date {
  @Override
  public Instant toInstant() {
    throw new java.lang.UnsupportedOperationException();
  }

  public Date(long date) {
    super(date);
  }
}
