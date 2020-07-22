package c04强化不可实例化的能力;

/**
 * @author zhout
 * @date 2020/7/22 15:06
 */
class UtilityClass {
  // 抑制默认构造函数
  private UtilityClass() {
    throw new AssertionError();
  }
}
