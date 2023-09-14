package com.springcloud.common.Controller;

import com.springcloud.common.Entity.Product;
import com.springcloud.common.Mapper.ProductMapper;
import com.springcloud.common.Service.elasticSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class search {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private elasticSercive elasticService;
	@RequestMapping("/search")

	public List<Product> demo()
	{
		return productMapper.getAllProducts();
	}
	@RequestMapping("/demo1")
	public void test() throws IOException {
elasticService.test();
	}

}
