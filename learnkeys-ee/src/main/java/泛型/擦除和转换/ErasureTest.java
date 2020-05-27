package 泛型.擦除和转换;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhouT
 * @date 2019/4/12 16:09
 */
public class ErasureTest {
  public static void main(String[] args) {
    Apple<Integer> a = new Apple<>(6);

    Integer as = a.getSize();

    Apple b = a;

    Number size1 = b.getSize();

    // b只知道size的类型是，下面对象引起编译错误
    // Integer size2 = b.getSize();
  }
}

@Setter
@Getter
class Apple<T extends Number> {
  T size;

  public Apple() {}

  public Apple(T size) {
    this.size = size;
  }
}
