package com.springcloud.common;

import com.springcloud.common.Exception.GlobalExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.springcloud.common.Mapper")

public class CommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonApplication.class,args);
	}

}
