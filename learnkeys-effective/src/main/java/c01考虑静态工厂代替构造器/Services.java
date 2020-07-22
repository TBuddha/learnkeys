package c01考虑静态工厂代替构造器;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhoutao@yunjiacloud.com
 * @date 2019/8/28 17:01
 */
class Services {

  private Services() {
  }

  private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

  private static final String DEFAULT_PROVIDER_NAME = "<dev>";

  //Provider register API
  public static void registerDefaultProvider(Provider provider) {
    registerProvider(DEFAULT_PROVIDER_NAME, provider);
  }

  public static void registerProvider(String name, Provider provider) {
    providers.put(name, provider);
  }

  public static Service newInstance() {
    return newInstance(DEFAULT_PROVIDER_NAME);
  }

  public static Service newInstance(String name) {
    Provider provider = providers.get(name);
    if (provider == null) {
      throw new IllegalArgumentException("No provider registered with name：" + name);
    }
    return provider.newService();
  }
}
