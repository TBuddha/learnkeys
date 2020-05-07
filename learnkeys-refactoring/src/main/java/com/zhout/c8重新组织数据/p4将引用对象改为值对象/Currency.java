package com.zhout.c8重新组织数据.p4将引用对象改为值对象;

/**
 * @author zhout
 * @date 2020/4/20 16:34
 */
class Currency {

  private String _code;

  public String getCode() {
    return _code;
  }

  private Currency(String code) {
    _code = code;
  }

  //在这里，Currency对象是不可变的，所以下一步就是为它定义equals()
  @Override
  public boolean equals(Object arg) {
    if (!(arg instanceof Currency)) return false;
    Currency other = (Currency) arg;
    return (_code.equals(other._code));
  }

  @Override
  public int hashCode() {
    return _code.hashCode();
  }

}
