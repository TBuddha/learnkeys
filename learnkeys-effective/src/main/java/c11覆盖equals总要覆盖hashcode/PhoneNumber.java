package c11覆盖equals总要覆盖hashcode;

/**
 * @author zhoutao
 * @date 2019/9/9 15:12
 */
class PhoneNumber {

  private final short areaCode;
  private final short prefix;
  private final short lineNumber;

  public PhoneNumber(int areaCode, int prefix, int lineNumber) {
    rangeCheck(areaCode, 999, "area code");
    rangeCheck(prefix, 999, "prefix");
    rangeCheck(lineNumber, 9999, "line number");
    this.areaCode = (short) areaCode;
    this.prefix = (short) prefix;
    this.lineNumber = (short) lineNumber;
  }

  private static void rangeCheck(int arg, int max, String name) {
    if (arg < 0 || arg > max) {
      throw new IllegalArgumentException(name + ":" + arg);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof PhoneNumber)) return false;

    PhoneNumber pn = (PhoneNumber) obj;
    return pn.areaCode == areaCode && pn.prefix == prefix && pn.lineNumber == lineNumber;
  }

  // 一种简单做法
  /*@Override public int hashCode(){
    int result = 17;
    result = 31 * result + areaCode;
    result = 31 * result + prefix;
    result = 31 * result + lineNumber;
    return result;
  }*/

  // 如果一个类是不可变的，并且计算散列码的开销比较大，考虑把散列码缓存在对象内部

  // lazily initialized，cached hashcode
  private volatile int hashCode;

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = 17;
      result = 31 * result + areaCode;
      result = 31 * result + prefix;
      result = 31 * result + lineNumber;
      hashCode = result;
    }
    return result;
  }
}
