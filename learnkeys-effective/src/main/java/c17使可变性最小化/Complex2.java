package c17使可变性最小化;

/**
 * @author zhoutao
 * @date 2019/9/9 14:32
 */
class Complex2 {

  private final double re;
  private final double im;

  private Complex2(double re, double im) {
    this.re = re;
    this.im = im;
  }

  public static Complex2 valueOf(double re, double im) {
    return new Complex2(re, im);
  }

  //扩展静态工厂，例：基于极坐标创建复数
  public static Complex2 valueOfPolar(double r, double theta) {
    return new Complex2(r * Math.cos(theta), r * Math.sin(theta));
  }
}
