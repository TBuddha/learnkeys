package 面向对象.super父类;

/**
 * @author zhouT
 * @date 2019/5/15 10:34
 */
class Creature {
  public Creature() {
    System.out.println("Creature无参数的构造器");
  }
}

class Animal extends Creature {
  public Animal(String name) {
    System.out.println("Animal带一个参数的构造器，该动物的name为" + name);
  }

  public Animal(String name, int age) {
    // 使用this调用同一个重载的构造器
    this(name);
    System.out.println("Animal带2个参数的构造器，其age为" + age);
  }
}

public class Wolf extends Animal {
  public Wolf() {
    // 显式调用父类有2个参数的构造器
    super("土狼", 3);
    System.out.println("Wolf无参数的构造器");
  }

  public static void main(String[] args) {
    new Wolf();
  }
}
