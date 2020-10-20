package org.example.c8重新组织数据.p13以子类取代型别码;

/**
 * @author zhout
 * @date 2020/4/24 17:31
 */
public abstract class AbstractEmployee {
  //此时我就可以移除Employee 中保存type code 的值域，将getType() 声明为一个抽象函数
  //private int _type;
  static final int ENGINEER = 0;
  static final int SALESMAN = 1;
  static final int MANAGER = 2;

  abstract int getType();

  static AbstractEmployee create(int type) {
    /**
     * 当然，我总是避免使用switch 语句。但这里只有一处用到switch 语句，并且只用于决定创建何种对象，这样的switch 语句是可以接受的。
     * 很自然地，在建立了这些subclass 之后，你就应该使用 Push Down Method(328) 和 Push Down Field(329)，
     * 将「只与特定种类的雇员相关」的函数和值域推到相关的subclass 去。
     */
    switch (type) {
      case ENGINEER:
        return new Engineer();
      case SALESMAN:
        return new Salesman();
      case MANAGER:
        return new Manager();
      default:
        throw new IllegalArgumentException("Incorrect type code value");
    }
  }
}

class Engineer extends AbstractEmployee {
  @Override
  int getType() {
    return Employee.ENGINEER;
  }
}

class Salesman extends AbstractEmployee {
  @Override
  int getType() {
    return Employee.SALESMAN;
  }
}

class Manager extends AbstractEmployee {
  @Override
  int getType() {
    return Employee.MANAGER;
  }
}
