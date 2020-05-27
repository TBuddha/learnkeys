package internet.基本网络支持;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author zhouT
 * @date 2019/构建器/21 16:28
 */
public class URLDecoderTest {
  public static void main(String[] args) throws Exception {
    // 将application/x-www-form-urlencoded字符串
    // 转换成普通字符串
    String keyWord = URLDecoder.decode("%E7%BD%91%E7%BB%9C", "UTF-8");
    System.out.println(keyWord);
    // 将普通字符串转换成
    // application/x-www-form-urlencoded字符串
    String urlStr = URLEncoder.encode("测试", "GBK");
    System.out.println(urlStr);
  }
}
