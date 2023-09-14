package com.springcloud.common.Controller;

import com.springcloud.common.Exception.BusinessException;
import com.springcloud.common.Exception.ErrorCodeimpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
	@RequestMapping("/demo")
	public String demo()
	{
		throw new BusinessException(ErrorCodeimpl.E_100101);

	}

}
