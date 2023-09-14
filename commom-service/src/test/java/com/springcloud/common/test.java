package com.springcloud.common;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class test {
	@Resource
	RestHighLevelClient test2;
@Test
	public void demo()
{
	System.out.println(test2);
}
}
