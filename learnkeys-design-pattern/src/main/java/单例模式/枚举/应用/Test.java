package 单例模式.枚举.应用;

/**
 * @author zhoutao@yunjiacloud.com
 * @date 2019/9/2 16:27
 */
class Test {

  public static void main(String[] args) {
//    System.out.println(BaiduApi.API.getClient());
//    System.out.println(BaiduApi.API.getClient());
//    System.out.println(BaiduApi.API.getClient());

    Singleton.INSTANCE.doSomething();
  }
}
