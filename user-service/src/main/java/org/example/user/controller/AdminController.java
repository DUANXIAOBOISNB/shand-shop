package org.example.user.controller;

import com.springcloud.common.Vo.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/test")
public String test()
{
	int i=1/0;
	return "sdfsd";
}
}
