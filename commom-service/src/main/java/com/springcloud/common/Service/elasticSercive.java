package com.springcloud.common.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.common.elasticIndex.userindex;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class elasticSercive {
	@Autowired
	RestHighLevelClient client;
   public void test() throws IOException {
	   CreateIndexRequest request=new CreateIndexRequest("user");
	   client.indices().create(request,RequestOptions.DEFAULT);
	   client.close();
   }
	public elasticSercive(RestHighLevelClient client) {
		this.client = client;
	}
	public SearchResponse searchDocuments(String query) throws IOException {
		SearchRequest searchRequest = new SearchRequest("your_index_name");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("field_name", query));
		searchRequest.source(searchSourceBuilder);

		return client.search(searchRequest, RequestOptions.DEFAULT);
	}
	/**
	 * 测试对象的操作
	 */


}
