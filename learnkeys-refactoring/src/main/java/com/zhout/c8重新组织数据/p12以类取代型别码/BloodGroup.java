package com.zhout.c8重新组织数据.p12以类取代型别码;

/**
 * 建立一个新的BloodGroup class，用以表示「血型」，并在这个实体中保存原本的类型码数值
 *
 * @author zhout
 * @date 2020/4/24 14:40
 */
public class BloodGroup {

  public static final BloodGroup O = new BloodGroup(0);
  public static final BloodGroup A = new BloodGroup(1);
  public static final BloodGroup B = new BloodGroup(2);
  public static final BloodGroup AB = new BloodGroup(3);
  private static final BloodGroup[] _values = {O, A, B, AB};

  private final int _code;

  private BloodGroup(int code) {
    _code = code;
  }

  // 将BloodGroup 中使用整数型别的函数声明为private （因为再没有人会使用它们了）
  //  public int getCode() {
  //    return _code;
  //  }
  private int getCode() {
    return _code;
  }

  //  public static BloodGroup code(int arg) {
  //    return _values[arg];
  //  }
  private static BloodGroup code(int arg) {
    return _values[arg];
  }
}
