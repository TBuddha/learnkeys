package 单例模式枚举;

/**
 * @author zhoutao@yunjiacloud.com
 * @date 2019/9/2 16:14
 */
enum Singleton implements MySingleton {
  INSTANCE {
    @Override
    public void doSomething() {
      System.out.println("complete singleton");
    }
  };

  public static MySingleton getInstance() {
    return Singleton.INSTANCE;
  }
}
