package 泛型.入门;

/**
 * @author zhouT
 * @date 2019/3/8 16:18
 */
public class Apple<T> {
  private T info;

  public Apple() {}

  public Apple(T info) {
    this.info = info;
  }

  public void setInfo(T info) {
    this.info = info;
  }

  public T getInfo() {
    return this.info;
  }

  public static void main(String[] args) {
    Apple<String> a1 = new Apple<>("ac");
    System.out.println(a1.getInfo());

    Apple<Double> a2 = new Apple<>(3.3);
    System.out.println(a2.getInfo());

    /*java内置.util.Collection<String> cs = new java内置.util.ArrayList<>();
    if(cs instanceof java内置.util.Collection<String>){
    }*/
  }
}
