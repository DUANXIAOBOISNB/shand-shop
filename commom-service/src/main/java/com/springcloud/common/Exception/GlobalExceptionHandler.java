package com.springcloud.common.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
@ResponseBody
@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorRestResult handle(MethodArgumentNotValidException exception)
{
	//返回错误字段
	String field = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getField();
	//返回错误信息
	String message = exception.getBindingResult().getFieldError().getDefaultMessage();
	return new ErrorRestResult(HttpStatus.BAD_REQUEST.toString(),field+message);
}
@ResponseBody
@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public  ErrorRestResult handle(Exception exception)
{
	if(exception instanceof BusinessException)
	{
		BusinessException ex = (BusinessException) exception;
		ErrorCode errorCode = ex.getErrorCode();
		int getcode = errorCode.getcode();
		String getdesc = errorCode.getdesc();
		return new ErrorRestResult(String.valueOf(getcode),getdesc);
	}
	return new ErrorRestResult(String.valueOf(ErrorCodeimpl.UNKNOWN.getcode()),exception.getMessage()!=null? exception.getMessage():ErrorCodeimpl.UNKNOWN.getdesc());

}


}
