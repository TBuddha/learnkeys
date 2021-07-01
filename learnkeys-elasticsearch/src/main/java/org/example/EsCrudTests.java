package org.example;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhout
 * @date 2021/4/15 11:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsCrudTests {

  @Resource
  private RestHighLevelClient restHighLevelClient;

  public static final String INDEX_NAME = "z_index";

  public final static String INDEX_TYPE = "zzz";

  // 测试索引的创建 Request PUT
  @Test
  public void testCreateIndex() throws IOException {
    // 1、创建索引请求
    CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME); // 2、客户端执行请求 IndicesClient,请求后获得响应
    CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
    System.out.println("createIndexResponse = " + createIndexResponse);
  }

  // 测试获取索引,判断其是否存在
  @Test
  public void testExistIndex() throws IOException {
    GetIndexRequest request = new GetIndexRequest(INDEX_NAME);
    boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    System.out.println("exists = " + exists);
  }

  // 测试删除索引
  @Test
  public void testDeleteIndex() throws IOException {
    DeleteIndexRequest request = new DeleteIndexRequest(INDEX_NAME); // 删除
    AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
    System.out.println("delete.isAcknowledged() = " + delete.isAcknowledged());
  }

  // 测试添加文档
  @Test
  public void testAddDocument() throws IOException {
    // 创建对象
    User user = new User("反反复复", 3);
    // 创建请求
    IndexRequest request = new IndexRequest().index(INDEX_NAME).type(INDEX_TYPE);

    // 规则 put /index/type/1
    request.id("1");
    request.timeout(TimeValue.timeValueSeconds(1));
    request.timeout("1s");

    // 将我们的数据放入请求 json
    request.source(JSON.toJSONString(user), XContentType.JSON);

    // 客户端发送请求 , 获取响应的结果
    IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
    System.out.println("indexResponse.toString() = " + indexResponse.toString());
    System.out.println("indexResponse.status() = " + indexResponse.status()); // 对应我们命令返回的状态 CREATED
  }

  // 获取文档，判断是否存在 get /index/type/1
  @Test
  public void testDocumentIsExists() throws IOException {
    GetRequest getRequest = new GetRequest(INDEX_NAME, INDEX_TYPE, "1");
    // 不获取返回的 _source 的上下文了
    getRequest.fetchSourceContext(new FetchSourceContext(false));
    getRequest.storedFields("_none_");
    boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
    System.out.println("exists = " + exists);
  }

  // 获得文档的信息
  @Test
  public void testGetDocument() throws IOException {
    GetRequest getRequest = new GetRequest(INDEX_NAME, INDEX_TYPE, "1");
    GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
    System.out.println("getResponse.getSourceAsString() = " + getResponse.getSourceAsString());// 打印文档的内容
    System.out.println("getResponse = " + getResponse); // 返回的全部内容和命令式一样的 }
  }

  // 更新文档的信息
  @Test
  public void testUpdateRequest() throws IOException {
    UpdateRequest updateRequest = new UpdateRequest(INDEX_NAME, INDEX_TYPE, "1");
    updateRequest.timeout("1s");
    User user = new User("Java", 18);
    updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
    UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
    System.out.println("updateResponse.status() = " + updateResponse.status());
  }

  // 删除文档记录
  @Test
  public void testDeleteRequest() throws IOException {
    DeleteRequest request = new DeleteRequest(INDEX_NAME, INDEX_TYPE, "1");
    request.timeout("1s");
    DeleteResponse deleteResponse = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
    System.out.println("deleteResponse.status() = " + deleteResponse.status());
  }

  // 特殊的，真的项目一般都会批量插入数据!
  @Test
  public void testBulkRequest() throws IOException {
    BulkRequest bulkRequest = new BulkRequest();
    bulkRequest.timeout("10s");

    List<User> userList = Lists.newArrayList();
    userList.add(new User("tt", 4));
    userList.add(new User("tt1", 4));
    userList.add(new User("z2rt3", 5));
    userList.add(new User("逃1", 7));
    userList.add(new User("逃2", 31));
    userList.add(new User("逃3", 33));

    // 批处理请求
    for (int i = 0; i < userList.size(); i++) {
      // 批量更新和批量删除，就在这里修改对应的请求就可以了
      //bulkRequest.add(new IndexRequest(INDEX_NAME).type(INDEX_TYPE).id("" + (i + 1)).source(JSON.toJSONString(userList.get(i)), XContentType.JSON));
      bulkRequest.add(new IndexRequest(INDEX_NAME).type(INDEX_TYPE).source(JSON.toJSONString(userList.get(i)), XContentType.JSON));
    }
    BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
    // 是否失败，返回 false 代表成功...
    System.out.println("bulkResponse.hasFailures() = " + bulkResponse.hasFailures());
  }

  // 查询
  // SearchRequest 搜索请求
  // SearchSourceBuilder 条件构造
  // HighlightBuilder 构建高亮
  // TermQueryBuilder 精确查询
  // MatchAllQueryBuilder
  // xxx QueryBuilder 对应我们刚才看到的命令!

  @Test
  public void testSearch() throws IOException {
    //    SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
    //    // 构建搜索条件
    //    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //    sourceBuilder.highlighter();
    //
    //    // 查询条件，我们可以使用 QueryBuilders 工具来实现
    //    // QueryBuilders.termQuery 精确
    //    // QueryBuilders.matchAllQuery() 匹配所有
    //    TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "桃红2");
    //    // MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
    //
    //    sourceBuilder.query(termQueryBuilder);
    //    sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
    //    searchRequest.source(sourceBuilder);
    //    SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    //    searchResponse.getHits();
    //
    //    System.out.println(JSON.toJSONString(searchResponse.getHits()));
    //    System.out.println("=================================");
    //
    //    for (SearchHit documentFields : searchResponse.getHits().getHits()) {
    //      System.out.println("documentFields.getSourceAsMap() = " + documentFields.getSourceAsMap());
    //    }

  }

  @Data
  static class User {

    private String name;
    private Integer age;
    private Date startTime;
    private Date endTIme;

    public User(String name, Integer age) {
      this.name = name;
      this.age = age;
      this.startTime = new Date();
      this.endTIme = tomorrow(startTime);
    }

    public Date tomorrow(Date startTime) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(startTime);
      calendar.add(Calendar.DATE, 1);
      return calendar.getTime();
    }
  }
}


