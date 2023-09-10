package com.springcloud.store.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.store.Entity.Product;
import com.springcloud.store.service.ProductService;
import com.springcloud.store.Mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【Product】的数据库操作Service实现
* @createDate 2023-09-10 15:21:20
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




