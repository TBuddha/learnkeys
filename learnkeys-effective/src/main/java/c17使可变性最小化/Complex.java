package c17使可变性最小化;

/**
 * @author zhoutao
 * @date 2019/9/9 10:09
 */
final class Complex {

  private final double re;
  private final double im;

  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  //没有相应的mutator(不要提供任何修改对象状态的方法)的访问器
  public double realPart() {
    return re;
  }

  public double imaginaryPart() {
    return im;
  }

  public Complex add(Complex c) {
    return new Complex(re + c.re, im + c.im);
  }

  public Complex subtract(Complex c) {
    return new Complex(re - c.re, im - c.im);
  }

  public Complex multiply(Complex c) {
    return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Complex)) {
      return false;
    }

    Complex c = (Complex) obj;

    return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
  }

  @Override
  public int hashCode() {
    int result = 17 + hashDouble(re);
    result = 31 + result + hashDouble(im);
    return result;
  }

  private int hashDouble(double val) {
    long longBits = Double.doubleToLongBits(val);
    return (int) (longBits ^ (longBits >>> 32));
  }

  @Override
  public String toString() {
    return "(" + re + " + " + im + ")";
  }

  /*public static void main(String[] args) {
    Complex complex = new Complex(1, 2);
    Complex multiply = new Complex(3, 4);

    System.out.println(complex.multiply(multiply));
  }*/
  public static void main(String[] args) {
    int i = 1;
    int j = 1;
    if(i == 2){
      System.out.println("one");
    } else if(j == 1){
      System.out.println("two");
    }
  }
}
