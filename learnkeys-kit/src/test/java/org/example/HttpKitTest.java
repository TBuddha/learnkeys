package org.example;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import org.example.httpclient.HttpKit;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

/**
 * @author zhout
 * @date 2020/4/8 15:21
 */
public class HttpKitTest {
  @Test
  public void test() throws Exception {
    HttpKit.HttpConnectionManager.setMaxTotal(100);
    HttpKit.HttpConnectionManager.setDefaultMaxPerRoute(1);
    HttpKit.get("https://easy-mock.com/mock/5ab6845e64bf8d1e392c169f/example/query?k=v")
        .param("key1", "value1")
        .param("key2", "value2")
        .header("hkey1", "hvalue1")
        .body();

    TimeUnit.MILLISECONDS.sleep(400);

    HttpKit.get("https://easy-mock.com/mock/5ab6845e64bf8d1e392c169f/example/query")
        .param("key1", "value1")
        .params("key2", "value2", "key3", "value3")
        .header("hkey1", "hvalue1")
        .header("key2", "value2", "key3", "value3")
        .responseCharset("UTF-8")
        .addResponseInterceptor(
            response -> {
              final HttpEntity entity = response.getEntity();
              System.out.println(EntityUtils.toString(entity));
              EntityUtils.consume(entity);
            })
        .code();

    TimeUnit.MILLISECONDS.sleep(400);

    HttpKit.get("https://easy-mock.com/mock/5ab6845e64bf8d1e392c169f/example/query")
        .params(Maps.newHashMap())
        .headers(Maps.newHashMap())
        .param("key1", "value1")
        .proxy(null, 0)
        .proxy(null, 0, null, null)
        .basic("username", "password")
        .timeout(30)
        .retryTimes(3)
        .receive(System.out);

    TimeUnit.MILLISECONDS.sleep(400);

    HttpKit.post("https://easy-mock.com/mock/5ab6845e64bf8d1e392c169f/example/post")
        .param("key1", "value1")
        .addResponseInterceptor(
            response -> {
              System.out.println(response.getStatusLine().getStatusCode());
            })
        .receive(System.out);

    TimeUnit.MILLISECONDS.sleep(400);

    HttpKit.post("https://easy-mock.com/mock/5ab6845e64bf8d1e392c169f/example/post")
        .json("{\"key1\":\"value1\"}")
        .receive(System.out);

    TimeUnit.MILLISECONDS.sleep(400);

    Path path = Files.createTempFile("httptest", ".jpg");
    Files.copy(
        this.getClass().getClassLoader().getResourceAsStream("files/test.jpg"),
        path,
        StandardCopyOption.REPLACE_EXISTING);
    HttpKit.post("https://easy-mock.com/mock/5ab6845e64bf8d1e392c169f/example/post")
        .param("key1", "value1")
        .part("test.txt", "测试数据".getBytes(Charsets.UTF_8))
        .part("test.jpg", path.toFile())
        .part("test2.txt", new ByteArrayInputStream("测试数据".getBytes(Charsets.UTF_8)))
        .receive(System.out);
    Files.delete(path);

    TimeUnit.MILLISECONDS.sleep(400);

    HttpKit.put("https://easy-mock.com/mock/5ab6845e64bf8d1e392c169f/example/put")
        .param("key1", "value1")
        .receive(System.out);

    TimeUnit.MILLISECONDS.sleep(400);

    HttpKit.delete("https://easy-mock.com/mock/5ab6845e64bf8d1e392c169f/example/delete")
        .param("key1", "value1")
        .receive(System.out);
  }
}
