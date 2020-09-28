package 单例模式.枚举.应用;

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
