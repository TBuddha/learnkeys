package 单例模式.枚举.应用;

/**
 * @author zhoutao@yunjiacloud.com
 * @date 2019/9/2 16:15
 */
class EnumSingleton {
  private EnumSingleton(){}

  public static EnumSingleton getInstance(){
    return Singleton.INSTANCE.getInstance();
  }

  private enum Singleton{
    INSTANCE;

    private EnumSingleton singleton;

    //JVM会保证此方法绝对只调用一次
    Singleton(){
      singleton = new EnumSingleton();
    }

    public EnumSingleton getInstance(){
      return singleton;
    }
  }

  public static void main(String[] args) {
    System.out.println(EnumSingleton.getInstance());
    System.out.println(EnumSingleton.getInstance());
    System.out.println(EnumSingleton.getInstance());
  }
}

/*public class EnumSingleton {
  private EnumSingleton(){}

  public static EnumSingleton getInstance(){
    return Singleton.INSTANCE.getInstance();
  }

  private enum Singleton{
    INSTANCE(new EnumSingleton());

    private EnumSingleton singleton;

    //JVM会保证此方法绝对只调用一次
    Singleton(EnumSingleton singleton){
      this.singleton = singleton;
    }

    public EnumSingleton getInstance(){
      return singleton;
    }
  }
}*/
