package com.springcloud.store.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.store.Entity.Category;
import com.springcloud.store.Service.CategoryService;
import com.springcloud.store.Mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【Category】的数据库操作Service实现
* @createDate 2023-09-10 15:09:34
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




