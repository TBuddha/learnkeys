package org.example;

import java.util.concurrent.TimeUnit;
import org.example.encrypt.MD5Utils;
import org.example.httpclient.HttpKit;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/12/16 10:33
 */
public class HomeTest {

//  private String host = "https://home-dev-cxcloud.cticloud.cn";
//  private String tenancyId = "TCC1000002";
//  private String orgId = "JG2000002";
//  private String deptId = "BM3000003";
//  private String deptToken = "025d2ec14ed59fdd5cece049359de199";
//  private String username = "admin_7000025";

  //private String host = "https://home-5.cticloud.cn";
  private String host = "https://home-dev-cxcloud.cticloud.cn";
  private String tenancyId = "";
  private String orgId = "";
  private String deptId = "";
  private String deptToken = "";
  private String username = "";

  @Test
  public void testDep() {
    String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
    String sign = MD5Utils.encode(deptId + timestamp + deptToken);
    //  /v1/api/announcement/getSystemAnnouncement
    String url = host + "/index/callcenter/ivr-list?type=1"
        + "&sign=" + sign
        + "&timestamp=" + timestamp
        + "&username=" + username
        + "&tenancyId=" + tenancyId
        + "&organizationId=" + orgId
        + "&departmentId=" + deptId
        + "&iframe=true";
    System.out.println(url);
  }

  @Test
  public void test() throws Exception {
    String timestamp = String.valueOf(System.currentTimeMillis());
    String sign = MD5Utils.encode(deptId + timestamp + deptToken);

    HttpKit.HttpConnectionManager.setMaxTotal(100);
    HttpKit.HttpConnectionManager.setDefaultMaxPerRoute(1);
    String result = HttpKit.get("https://home-dev-cxcloud.cticloud.cn/v1/api/announcement/getSystemAnnouncement")
        .params("tenancyId", tenancyId)
        .params("organizationId", orgId)
        .params("departmentId", deptId)
        .params("sign", sign)
        .params("timestamp", timestamp)
        .params("username", username)
        .body();
    System.out.println(result);

    TimeUnit.MILLISECONDS.sleep(400);
  }

}
