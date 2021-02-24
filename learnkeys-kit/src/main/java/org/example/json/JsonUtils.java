package org.example.json;

import com.alibaba.fastjson.JSONObject;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhout
 * @date 2020/11/17 14:07
 */
public class JsonUtils {

  /** 预编译 */
  private static final String REGEX_JSONP = "\\w+\\(('\\{[^()]+\\}')\\)";
  private static final String REGEX_JSONP1 = "\\w+\\('(\\{[^()]+\\})'\\)";

  private static final Pattern PATTERN_REGEX_JSONP = Pattern.compile(REGEX_JSONP1);

  /** 兼容jsonp和普通json */
  public static JSONObject jsonpToJson(String data) {
    Matcher matcher = PATTERN_REGEX_JSONP.matcher(data);
    if (matcher.find()) {
      return JSONObject.parseObject(matcher.group(1));
    }
    return JSONObject.parseObject(data);
  }

  public static void main(String[] args) {
    String nojsonp =
            "null('{\"validateType\":\"2\",\"departmentId\":\"BM3000003\",\"enterpriseId\":\"7000025\",\"timestamp\":\"1605581289\",\"sign\":\"7a6c39fd50b3634d1683de9f2213e546\",\"cno\":\"000\",\"sessionKey\":\"ad941a70-27ee-4694-9640-6ce484203bf7\",\"result\":0}')";
    String jsonp = "jsonp({ \"a\": \"1234\", \"b\": 9999 })";
    String json = "{'ccc':'32'}";

        String REGEX_JSONP = "\\w+\\((\\{[^()]+\\})\\)";


        Pattern PATTERN_REGEX_JSONP = Pattern.compile(REGEX_JSONP);

        Matcher matcher = PATTERN_REGEX_JSONP.matcher(jsonp);
        if(matcher.find()){
          System.out.println(matcher.group(1));
        }
    System.out.println(UUID.randomUUID().toString().replace("-", ""));
    System.out.println(String.format("%s(%s)", "zhouta(111111)","111111"));
  }
}
