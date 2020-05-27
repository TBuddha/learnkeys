package reflect.类加载器;

import java.net.URL;

/**
 * @author zhoutao
 * @date 2019/7/17 17:36
 */
public class BootstrapTest {
  public static void main(String[] args) {
    // 获取根类加载器所加载的全部URL数组
    URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
    // 遍历、输出根类加载器加载的全部URL
    for (int i = 0; i < urls.length; i++) {
      System.out.println(urls[i].toExternalForm());
    }
  }
}
