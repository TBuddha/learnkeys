package org.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import org.apache.http.HttpException;
import org.example.encrypt.MD5Utils;
import org.example.httpclient.HttpKit;
import org.junit.Test;

/**
 * @author zhout
 * @date 2021/1/14 15:48
 */
public class CCHomeTest {

  private String enterpriseId = "7000025";

  private String token = "025d2ec14ed59fdd5cece049359de199";

  private String host = "https://api-dev-cxcloud.cticloud.cn";

  private String updatePath = "/interface/v10/manager/setPause";

  private String queryPath = "/interface/v10/agent/onlineAgentList";

  //队列号：可传多个队列，多个值之间以英文逗号,分隔
  private String qnos;

  //座席号：可传多个座席号，多个值之间以英文逗号,分隔
  private String cnos = "1064";

  //座席状态：s1-空闲，s2-置忙，s3-整理，s4-呼叫中，s5-响铃，s6-通话；可传多个状态码，多个值之间以英文逗号,分隔
  private String stateCode = "s2,s3,s4,s5,s6";

  //置忙类型：1-普通，2-休息，3-IM，4-强制；可传多个状态码，多个值之间以英文逗号,分隔
  private String pauseType;

  //置忙原因：可指定多个置忙原因，多个值之间以英文逗号,分隔
  private String pauseDescription;

  @Test
  public void test() throws IOException, HttpException {
    Map<String, Object> params = this.buildParams();
    String result = HttpKit.post(host + queryPath)
        .params(params).body();
    System.out.println(result);
  }

  public Map<String, Object> buildParams() {
    long timestamp = System.currentTimeMillis() / 1000;
    Map<String, Object> params = Maps.newHashMap();
    /*
     * 验证类型：1：使用部门编号（departmentId）验证；2：使用呼叫中心编号（enterpriseId）验证
     */
    params.put("validateType", 2);
    params.put("enterpriseId", enterpriseId);
    params.put("timestamp", timestamp);
    params.put("sign", MD5Utils.encode(enterpriseId + timestamp + token));
    params.put("cnos", cnos);
    params.put("stateCode", stateCode);
    return params;
  }

}
