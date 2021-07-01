package org.example;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhout
 * @date 2021/4/15 10:00
 */
@Configuration
public class RestClientConfiguration {

  private String host = "68.79.29.229";

  private Integer port = 9200;

  private String scheme = "http";

  private String username = "elastic";

  private String password = "elastic";

  private Integer connectionTimeout = 1500;

  private Integer socketTimeout = 30000;

  private Integer connectionRequestTimout = 500;

  private Integer maxConnectionNum = 100;

  private Integer maxConnectionPerRoute = 100;

  @Bean
  public RestHighLevelClient restHighLevelClient() {
    String[] hosts = host.split(",");
    HttpHost[] httpHosts = new HttpHost[hosts.length];
    for (int i = 0; i < hosts.length; i++) {
      httpHosts[i] = new HttpHost(hosts[i], port, scheme);
    }

    // 构建restClientBuilder 并配置
    RestClientBuilder restClientBuilder = RestClient.builder(httpHosts)
        .setHttpClientConfigCallback(httpClientBuilder -> {

          httpClientBuilder.setMaxConnTotal(maxConnectionNum);
          httpClientBuilder.setMaxConnPerRoute(maxConnectionPerRoute);
          httpClientBuilder.setDefaultCredentialsProvider(this.credentialsProvider(username, password));
          return httpClientBuilder;
        })
        .setRequestConfigCallback(requestConfigBuilder -> {
          requestConfigBuilder.setSocketTimeout(socketTimeout);
          requestConfigBuilder.setConnectTimeout(connectionTimeout);
          requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimout);
          return requestConfigBuilder;
        });

    return new RestHighLevelClient(restClientBuilder);
  }

  private CredentialsProvider credentialsProvider(String username, String password) {
    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
    return credentialsProvider;
  }
}
