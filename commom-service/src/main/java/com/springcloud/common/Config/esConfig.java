package com.springcloud.common.Config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class esConfig {
	@Bean
	public RestHighLevelClient test2()
	{
		return new RestHighLevelClient( RestClient.builder(new HttpHost("192.168.137.132",9200,"http")));
	}

}
