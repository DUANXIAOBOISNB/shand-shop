package com.springcloud.store.Controller;

// import org.example.gateway.Exception.BusinessException;
// import org.example.gateway.Exception.ErrorCodeimpl;
import com.springcloud.common.Exception.BusinessException;
import com.springcloud.common.Exception.ErrorCodeimpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
	@RequestMapping("/op")
	public void demo()
	{

		throw new BusinessException(ErrorCodeimpl.E_100101);

	}

}
