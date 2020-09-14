package com.zhout.httpclient;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhout.httpclient.UncheckedException;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * @author zhout
 * @date 2020/4/8 15:09
 */
public class HttpKit {
  /**
   * GET 请求, 兼容 HTTP 和 HTTPS 请求
   *
   * @param url 请求的地址
   * @return {@link HttpRequest}
   */
  public static HttpRequest get(String url) {
    return new HttpRequest(url, RequestMethod.GET);
  }

  /**
   * PUT 请求, 兼容 HTTP 和 HTTPS 请求
   *
   * @param url 请求的地址
   * @return {@link HttpRequest}
   */
  public static HttpRequest put(String url) {
    return new HttpRequest(url, RequestMethod.PUT);
  }

  /**
   * POST 请求, 兼容 HTTP 和 HTTPS 请求
   *
   * @param url 请求的地址
   * @return {@link HttpRequest}
   */
  public static HttpRequest post(String url) {
    return new HttpRequest(url, RequestMethod.POST);
  }

  /**
   * DELETE 请求, 兼容 HTTP 和 HTTPS 请求
   *
   * @param url 请求的地址
   * @return {@link HttpRequest}
   */
  public static HttpRequest delete(String url) {
    return new HttpRequest(url, RequestMethod.DELETE);
  }

  /**
   * 支持的请求方法
   *
   * @author fanlychie
   */
  private enum RequestMethod {
    GET,
    POST,
    PUT,
    DELETE
  }

  /**
   * 封装 HTTP 请求参数和操作
   *
   * @author fanlychie
   */
  public static final class HttpRequest {

    // 请求的地址
    private String url;

    // 请求体内容
    private String json;

    // 请求方法
    private RequestMethod method;

    // 失败重试的次数
    private int retryTimes = 3;

    // 请求超时的秒数
    private int timeout = 30;

    // 读取结果使用的字符集编码
    private String responseCharset = "UTF-8";

    // 请求参数
    private Map<String, String> params;

    // 请求头参数
    private Map<String, String> headers;

    // 代理端口
    private int proxyPort;

    // 代理主机
    private String proxyHost;

    private String proxyUsername;

    private String proxyPassword;

    private String basicUsername;

    private String basicPassword;

    private Map<String, Object> parts;

    private List<HttpResponseInterceptor> responseInterceptors = Lists.newArrayList();

    // 私有构造子
    private HttpRequest(String url, RequestMethod method) {
      this.url = url;
      this.method = method;
    }

    /**
     * 设置请求体, JSON 参数可设于此域
     *
     * @param json 请求体内容
     * @return {@link HttpRequest}
     */
    public HttpRequest json(String json) {
      this.json = json;
      return this;
    }

    /**
     * 设置失败重试的次数, 默认值 0
     *
     * @param retryTimes 失败重试的次数
     * @return {@link HttpRequest}
     */
    public HttpRequest retryTimes(int retryTimes) {
      this.retryTimes = retryTimes;
      return this;
    }

    /**
     * 超时的秒数, 默认 30s
     *
     * @param timeout 超时的秒
     * @return {@link HttpRequest}
     */
    public HttpRequest timeout(int timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * 设置代理
     *
     * @param host 代理主机
     * @param port 代理端口
     * @return {@link HttpRequest}
     */
    public HttpRequest proxy(String host, int port) {
      return proxy(host, port, null, null);
    }

    /**
     * 设置代理
     *
     * @param host 代理主机
     * @param port 代理端口
     * @return {@link HttpRequest}
     */
    public HttpRequest proxy(String host, int port, String username, String password) {
      this.proxyHost = host;
      this.proxyPort = port;
      this.proxyUsername = username;
      this.proxyPassword = password;
      return this;
    }

    public HttpRequest basic(String basicUsername, String basicPassword) {
      this.basicUsername = basicUsername;
      this.basicPassword = basicPassword;
      return this;
    }

    /**
     * 设置请求头参数表
     *
     * @param header 请求头参数表
     * @return {@link HttpRequest}
     */
    public HttpRequest headers(Map<String, Object> header) {
      this.headers = convertMap(header);
      return this;
    }

    /**
     * 设置请求头参数键值对
     *
     * @param nameValues 请求头参数键值对
     * @return {@link HttpRequest}
     */
    public HttpRequest header(String... nameValues) {
      this.headers = convertMap(nameValues);
      return this;
    }

    /**
     * 添加请求头参数
     *
     * @param name 参数名
     * @param value 参数值
     * @return
     */
    public HttpRequest header(String name, Object value) {
      if (this.headers == null) {
        this.headers = Maps.newHashMap();
      }
      headers.put(name, value.toString());
      return this;
    }

    /**
     * 设置请求参数表
     *
     * @param params 请求参数表
     * @return {@link HttpRequest}
     */
    public HttpRequest params(Map params) {
      this.params = convertMap(params);
      return this;
    }

    /**
     * 设置请求参数键值对
     *
     * @param nameValues 请求参数键值对
     * @return {@link HttpRequest}
     */
    public HttpRequest params(Object... nameValues) {
      this.params = convertMap(nameValues);
      return this;
    }

    /**
     * 添加请求参数
     *
     * @param name 参数名
     * @param value 参数值
     * @return
     */
    public HttpRequest param(String name, Object value) {
      if (this.params == null) {
        this.params = Maps.newHashMap();
      }
      params.put(name, value.toString());
      return this;
    }

    private void addPart(String name, Object object) {
      if (parts == null) {
        this.parts = Maps.newHashMap();
      }
      this.parts.put(name, object);
    }

    public HttpRequest part(String name, File file) {
      addPart(name, file);
      return this;
    }

    public HttpRequest part(String name, InputStream is) {
      addPart(name, is);
      return this;
    }

    public HttpRequest part(String name, byte[] bytes) {
      addPart(name, bytes);
      return this;
    }

    /**
     * 设置读取结果使用的字符集编码
     *
     * @param responseCharset 读取结果使用的字符集编码, 默认 UTF-8
     * @return {@link HttpRequest}
     */
    public HttpRequest responseCharset(String responseCharset) {
      this.responseCharset = responseCharset;
      return this;
    }

    public HttpRequest addResponseInterceptor(HttpResponseInterceptor responseInterceptor) {
      this.responseInterceptors.add(responseInterceptor);
      return this;
    }

    public String body() throws IOException, HttpException {
      try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        receive(baos);
        return baos.toString(responseCharset);
      }
    }

    public int code() throws IOException {
      HttpUriRequest request = getHttpUriRequest();
      CloseableHttpClient client = null;
      CloseableHttpResponse response = null;
      try {
        client = getHttpClient();
        response = client.execute(request);
        if (responseInterceptors != null && !responseInterceptors.isEmpty()) {
          for (HttpResponseInterceptor interceptor : responseInterceptors) {
            interceptor.interceptResponse(response);
          }
        }
        return response.getStatusLine().getStatusCode();
      } finally {
        HttpClientUtils.closeQuietly(response);
        HttpClientUtils.closeQuietly(client);
      }
    }

    public void receive(OutputStream outputStream) throws IOException {
      HttpUriRequest request = getHttpUriRequest();
      CloseableHttpClient client = null;
      CloseableHttpResponse response = null;
      try {
        client = getHttpClient();
        response = client.execute(request);
        if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
          if (responseInterceptors != null && !responseInterceptors.isEmpty()) {
            for (HttpResponseInterceptor interceptor : responseInterceptors) {
              interceptor.interceptResponse(response);
            }
          }
          final HttpEntity entity = response.getEntity();
          entity.writeTo(outputStream);
          EntityUtils.consume(entity);
        } else {
          throw new HttpResponseException(
              response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase());
        }

      } finally {
        HttpClientUtils.closeQuietly(response);
        HttpClientUtils.closeQuietly(client);
      }
    }

    /**
     * 转换参数为散列表
     *
     * @param obj 被转换的参数
     * @return Map
     */
    private Map<String, String> convertMap(Object obj) {
      Map<String, String> target = new HashMap<>();
      if (obj instanceof Map) {
        Map<?, ?> map = (Map<?, ?>) obj;
        map.forEach((k, v) -> target.put(k.toString(), v.toString()));
      } else if (obj.getClass().isArray()) {
        Object[] array = (Object[]) obj;
        IntStream.range(0, array.length)
            .filter((i) -> i % 2 == 0)
            .forEach((i) -> target.put(array[i].toString(), array[i + 1].toString()));
      }
      return target;
    }

    /**
     * 构建 HttpUriRequest
     *
     * @param base HttpUriRequest
     * @return HttpUriRequest
     */
    private HttpUriRequest buildHttpUriRequest(HttpUriRequest base) {
      if (headers != null && !headers.isEmpty()) {
        headers.forEach((k, v) -> base.addHeader(k, v));
      }
      return base;
    }

    /**
     * 构建 HttpUriRequest
     *
     * @param base HttpEntityEnclosingRequestBase
     * @return HttpUriRequest
     * @throws Exception
     */
    private HttpUriRequest buildHttpUriRequest(HttpEntityEnclosingRequestBase base) {
      if (headers == null) {
        headers = Maps.newHashMap();
      }
      if (parts != null && !parts.isEmpty()) {
        final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        parts.forEach(
            (k, v) -> {
              if (v instanceof File) {
                builder.addBinaryBody(k, (File) v);
              } else if (v instanceof InputStream) {
                builder.addBinaryBody(k, (InputStream) v);
              } else if (v instanceof byte[]) {
                builder.addBinaryBody(k, (byte[]) v);
              }
            });
        if (params != null && !params.isEmpty()) {
          params.forEach((k, v) -> builder.addTextBody(k, v));
        }
        base.setEntity(builder.build());
        return buildHttpUriRequest((HttpUriRequest) base);
      }
      // 处理请求参数
      if (params != null && !params.isEmpty()) {
        // 参数键值对数组
        List<NameValuePair> nameValuePairs = Lists.newArrayList();
        params.forEach((k, v) -> nameValuePairs.add(new BasicNameValuePair(k, v)));
        // 如果有参数, 设置请求参数
        if (!nameValuePairs.isEmpty()) {
          base.setEntity(new UrlEncodedFormEntity(nameValuePairs, Charsets.UTF_8));
        }
      }
      // 处理请求参数
      else if (json != null && !json.isEmpty()) {
        base.setEntity(new StringEntity(json, APPLICATION_JSON));
      }

      return buildHttpUriRequest((HttpUriRequest) base);
    }

    /**
     * 构建 HttpUriRequest
     *
     * @return HttpUriRequest
     * @throws Exception
     */
    private HttpUriRequest buildHttpUriRequest() {
      if (params != null && !params.isEmpty()) {
        StringBuilder paramStr = new StringBuilder();
        params.forEach(
            (k, v) -> {
              if (paramStr.length() > 0) {
                paramStr.append("&");
              }
              paramStr.append(k).append("=").append(encode(v));
            });
        if (paramStr.length() > 0) {
          if (url.contains("?")) {
            url += "&" + paramStr;
          } else {
            url += "?" + paramStr;
          }
        }
      }
      return buildHttpUriRequest(RequestBuilder.get().setUri(url).build());
    }

    /**
     * 获取 HttpUriRequest 对象
     *
     * @return HttpUriRequest
     * @throws Exception
     */
    private HttpUriRequest getHttpUriRequest() {
      switch (method) {
        case GET:
          return buildHttpUriRequest();
        case PUT:
          return buildHttpUriRequest(new HttpPut(url));
        case POST:
          return buildHttpUriRequest(new HttpPost(url));
        case DELETE:
          return buildHttpUriRequest(new HttpDelete(url));
        default:
          throw new UnsupportedOperationException("Unsupport " + method + " request.");
      }
    }

    /**
     * 编码字符串
     *
     * @param str 源字串
     * @return 返回UTF-8编码的内容
     */
    private String encode(String str) {
      try {
        return URLEncoder.encode(str, "UTF-8");
      } catch (Exception e) {
        throw new UncheckedException(e);
      }
    }

    /**
     * 获取客户端请求对象
     *
     * @return CloseableHttpClient
     * @throws Exception
     */
    private CloseableHttpClient getHttpClient() {
      CredentialsProvider credentialsProvider = null;
      RequestConfig.Builder requestConfigBuilder =
          RequestConfig.custom()
              // 设置连接超时
              .setConnectTimeout(timeout * 1000)
              // 设置读取超时
              .setSocketTimeout(timeout * 1000)
              .setConnectionRequestTimeout(timeout * 1000);
      // 设置代理
      if (proxyHost != null && !proxyHost.isEmpty() && proxyPort > 0) {
        HttpHost httpHost = new HttpHost(proxyHost, proxyPort);
        requestConfigBuilder.setProxy(httpHost);

        if (!Strings.isNullOrEmpty(proxyUsername)) {
          if (credentialsProvider == null) {
            credentialsProvider = new BasicCredentialsProvider();
          }
          credentialsProvider.setCredentials(
              new AuthScope(httpHost),
              new UsernamePasswordCredentials(proxyUsername, proxyPassword));
        }
      }
      if (!Strings.isNullOrEmpty(basicUsername)) {
        if (credentialsProvider == null) {
          credentialsProvider = new BasicCredentialsProvider();
        }
        URI uri;
        try {
          uri = new URI(url);
        } catch (URISyntaxException e) {
          throw new UncheckedException(e);
        }
        credentialsProvider.setCredentials(
            new AuthScope(uri.getHost(), uri.getPort(), AuthScope.ANY_REALM),
            new UsernamePasswordCredentials(basicUsername, basicPassword));
      }

      HttpClientBuilder builder =
          HttpClients.custom()
              .setDefaultRequestConfig(requestConfigBuilder.build())
              .setConnectionManager(HttpConnectionManager.POOLING_CONNECTION_MANAGER)
              .setConnectionManagerShared(true)
              .setRetryHandler(new StandardHttpRequestRetryHandler(retryTimes, true));
      if (credentialsProvider != null) {
        builder.setDefaultCredentialsProvider(credentialsProvider);
      }
      // 是否使用SSL协议链接
      if (url.startsWith("https")) {
        builder.setSSLSocketFactory(SSLSelfSigned.SSL_CONNECTION_SOCKET_FACTORY).build();
      }
      return builder.build();
    }
  }

  public interface HttpResponseInterceptor {
    void interceptResponse(HttpResponse response) throws IOException;
  }

  /** 连接管理器 */
  public static class HttpConnectionManager {
    /** 普通连接管理器 */
    public static final HttpClientConnectionManager BASIC_CONNECTION_MANAGER;
    /** 连接池管理器 */
    public static final HttpClientConnectionManager POOLING_CONNECTION_MANAGER;

    static {
      Registry<ConnectionSocketFactory> r =
          RegistryBuilder.<ConnectionSocketFactory>create()
              .register("http", PlainConnectionSocketFactory.getSocketFactory())
              .register("https", SSLSelfSigned.SSL_CONNECTION_SOCKET_FACTORY)
              .build();
      // 普通连接管理器
      BASIC_CONNECTION_MANAGER = new BasicHttpClientConnectionManager(r);
      // 连接池管理器
      PoolingHttpClientConnectionManager pooling = new PoolingHttpClientConnectionManager(r);
      // 设置最大连接数
      pooling.setMaxTotal(1000);
      // 设置每个路由基础上的最大连接数
      pooling.setDefaultMaxPerRoute(300);
      POOLING_CONNECTION_MANAGER = pooling;
    }

    private HttpConnectionManager() {}

    /** @param max httpClient 最大连接数 */
    public static void setMaxTotal(int max) {
      ((PoolingHttpClientConnectionManager) POOLING_CONNECTION_MANAGER).setMaxTotal(max);
    }

    /** @param max 每个路由基础上的最大连接数 */
    public static void setDefaultMaxPerRoute(int max) {
      ((PoolingHttpClientConnectionManager) POOLING_CONNECTION_MANAGER).setDefaultMaxPerRoute(max);
    }
  }

  /** 如果 https 使用自签名证书（不是第三方机构颁发的证书），无法通过验证； 因此需要创建一个SSL连接，接受自签名证书的信任策略，使其通过验证。 */
  public static class SSLSelfSigned {
    public static final SSLConnectionSocketFactory SSL_CONNECTION_SOCKET_FACTORY;

    static {
      SSLContext sslContext = null;
      try {
        sslContext =
            SSLContexts.custom()
                .loadTrustMaterial(null, (TrustStrategy) (chain, authType) -> true)
                .build();
      } catch (Exception e) {
      }
      SSL_CONNECTION_SOCKET_FACTORY =
          new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
    }

    private SSLSelfSigned() {}
  }
}
