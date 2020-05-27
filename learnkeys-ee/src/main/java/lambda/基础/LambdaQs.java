package lambda.基础;

/**
 * @author zhoutao
 * @date 2019/5/27 16:49
 */
interface Eatable {
  void taste();
}

interface Flyable {
  void fly(String weather);
}

interface Addable {
  int add(int a, int b);
}

public class LambdaQs {
  public void eat(Eatable e) {
    System.out.println(e);
    e.taste();
  }

  public void drive(Flyable f) {
    System.out.println("驾驶：" + f);
    f.fly("晴天");
  }

  public void test(Addable a) {
    System.out.println("5+3=" + a.add(5, 3));
  }

  public static void main(String[] args) {
    LambdaQs qs = new LambdaQs();
    // 只有一条语句可以省略花括号
    qs.eat(() -> System.out.println("味道不错"));

    qs.drive(
        weather -> {
          System.out.println("今天的天气是：" + weather);
          System.out.println("直升飞机平稳");
        });

    qs.test((a, b) -> a + b);
  }
}
