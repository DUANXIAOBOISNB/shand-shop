package com.springcloud.common.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class demo1 {

	public static void main(String[] args) {
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.137.132", 9200, "http")));
		System.out.println(client);
	}

}
