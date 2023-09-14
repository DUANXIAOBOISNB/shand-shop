package com.springcloud.common.Mapper;


import com.springcloud.common.Entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper {
	 List<Product> getAllProducts();
}