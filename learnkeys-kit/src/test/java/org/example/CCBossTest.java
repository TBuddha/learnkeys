package org.example;

import java.util.concurrent.TimeUnit;
import org.example.encrypt.MD5Utils;
import org.example.httpclient.HttpKit;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/12/24 17:12
 */
public class CCBossTest {

  private String tenancyId = "TCC1000002";

  @Test
  public void testBoss() throws Exception {
    String timestamp = String.valueOf(System.currentTimeMillis());
    String sign = MD5Utils.encode( timestamp );

    HttpKit.HttpConnectionManager.setMaxTotal(100);
    HttpKit.HttpConnectionManager.setDefaultMaxPerRoute(1);
    String result = HttpKit.get("https://boss-dev-cxcloud.cticloud.cn/api/boss/queryTrunks")
        .params("start", 1)
        .params("limit", 10)
        .params("sign", sign)
        .params("timestamp", timestamp)
        .body();
    System.out.println(result);

    TimeUnit.MILLISECONDS.sleep(400);
  }

}
