package 单例模式枚举;

/**
 * @author zhoutao@yunjiacloud.com
 * @date 2019/9/2 16:24
 */
enum BaiduApi {
  API;
  public static final String APP_ID = "43543";
  public static final String API_KEY = "K9dpjF0HqltT534ePgPuhQCrhsG";
  public static final String SECRET_KEY = "8fd9WaY7BeKkT34534KMY3rIs3oSSFmzxRep0";

  private AipNlp client;

  private BaiduApi() {
    client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
  }

  public AipNlp getClient() {
    return this.client;
  }
}
