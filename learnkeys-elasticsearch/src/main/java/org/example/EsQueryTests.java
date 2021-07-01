package org.example;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Resource;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhout
 * @date 2021/4/16 09:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsQueryTests {

  @Resource
  private RestHighLevelClient restHighLevelClient;

  @Test
  public void testAll() throws IOException {
    QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
    this.resultOut(queryBuilder);
  }

  @Test
  public void testTerm() throws IOException {
    // 精确查询
    BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
    queryBuilder.filter(QueryBuilders.termQuery("name", "桃红1"));
    this.resultOut(queryBuilder);
  }

  /**
   * must (and) 所有的条件都要符合 where id = 1 and name = xxx
   * should (or)所有的条件都要符合 where id = 1 and name = xxx
   * must_not (not)
   */
  @Test
  public void testCon() throws IOException {
    QueryBuilder queryBuilder = QueryBuilders.boolQuery()
        .should(QueryBuilders.termQuery("name", "tt"))
        .should(QueryBuilders.termQuery("name", "tt1"))
        .mustNot(QueryBuilders.termQuery("name", "tt1"));
    this.resultOut(queryBuilder);

  }

  /**
   * 中文条件查询
   * 此处使用模糊匹配查询 类比数据库中 like  name代表的是字段名，‘动态'代表的是匹配的关键字
   * QueryBuilder 适用于单个字段查询（matchPhraseQuery是没有用分词器，matchQuery会使用分词器，
   * 将我们输入的值进行分割，如：“java动态”会分割成：“java”,“动态”）
   */
  @Test
  public void testLike() throws IOException {
    QueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("name", "桃红");
    // QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "桃红");
    // 声明where条件
    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(queryBuilder);
    this.resultOut(boolQueryBuilder);
  }

  // 模糊查询，?匹配单个字符，*匹配多个字符
  @Test
  public void testLike1() throws IOException {
    QueryBuilder queryBuilder = QueryBuilders.wildcardQuery("name", "*t*");
    //QueryBuilder queryBuilder = QueryBuilders.wildcardQuery("name", "?t*");
    this.resultOut(queryBuilder);
  }

  // 复合模糊查询must(相当于SQL中的and)
  @Test
  public void testLikeAnd() throws IOException {
    WildcardQueryBuilder queryBuilder1 = QueryBuilders.wildcardQuery("name", "*t*");
    WildcardQueryBuilder queryBuilder2 = QueryBuilders.wildcardQuery("name", "*z*");
    BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
    queryBuilder.must(queryBuilder1);
    queryBuilder.must(queryBuilder2);

    this.resultOut(queryBuilder);
  }

  // 模糊查询 should(相当于SQL中的or关键字)
  @Test
  public void testLikeOr() throws IOException {
    // 复合模糊查询must(相当于SQL中的and)
    WildcardQueryBuilder queryBuilder1 = QueryBuilders.wildcardQuery("name", "*t*");
    WildcardQueryBuilder queryBuilder2 = QueryBuilders.wildcardQuery("name", "*z*");
    BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
    queryBuilder.should(queryBuilder1);
    queryBuilder.should(queryBuilder2);

    this.resultOut(queryBuilder);
  }

  // 多个字段匹配一个值
  @Test
  public void testLikeMulti() throws IOException {
    //搜索name字段或age字段中包含有"3"的数据，并且这两个字段中的值必须等于"3"
    QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery("3","name", "age");

    this.resultOut(queryBuilder);
  }

  private void resultOut(QueryBuilder queryBuilder) throws IOException {
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //填充查询条件
    sourceBuilder.query(queryBuilder);
    sourceBuilder.from(0);
    sourceBuilder.size(5);
    //按最后一条消息的时间排序,降序
    sourceBuilder.sort("_id", SortOrder.DESC);

    SearchRequest searchRequest = new SearchRequest(EsCrudTests.INDEX_NAME);
    searchRequest.source(sourceBuilder);
    //忽略索引不存在的异常
    searchRequest.indicesOptions(IndicesOptions.lenientExpandOpen());
    searchRequest.types(EsCrudTests.INDEX_TYPE);
    searchRequest.source(sourceBuilder);

    SearchResponse response = restHighLevelClient.search(searchRequest);

    if (Objects.isNull(response) || !Objects.equals(RestStatus.OK, response.status())) {
      System.out.println("empty1");
    }
    SearchHits hits = response.getHits();

    if (hits.getTotalHits() == 0) {
      System.out.println("empty2");
    }

    SearchHit[] searchHits = hits.getHits();
    for (SearchHit hit : searchHits) {
      System.out.println("hit.getSourceAsString() = " + hit.getSourceAsString());
    }
  }
}
