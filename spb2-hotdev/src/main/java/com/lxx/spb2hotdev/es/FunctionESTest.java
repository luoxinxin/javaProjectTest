package com.lxx.spb2hotdev.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.AsyncSearchClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FunctionESTest {

//    @Autowired
//    private ElasticsearchRestTemplate template;

// 上述操作形式是ES早期的操作方式，使用的客户端被称为Low Level Client，
//    这种客户端操作方式性能方面略显不足，于是ES开发了全新的客户端操作方式，
//    称为High Level Client
//    @Autowired
//    private RestHighLevelClient client;

    // 创建 RestHighLevelClient 实例
    RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(new HttpHost("localhost", 9200, "http")));

    public void test() throws IOException {
        //client.putScript()
        // 准备索引请求
        IndexRequest request = new IndexRequest("my_index");
        request.id("1");
        String jsonString = "{\"title\":\"Elasticsearch\",\"content\":\"You know, for search\"}";
        request.source(jsonString, XContentType.JSON);

        // 执行索引请求
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        System.out.println("Index response: " + indexResponse.toString());
    }

    public void test1() throws IOException {
        // 准备搜索请求
        SearchRequest searchRequest = new SearchRequest("my_index");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("title", "Elasticsearch"));
        searchRequest.source(searchSourceBuilder);

        // 执行搜索请求
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("Search response: " + searchResponse.toString());

    }

}
