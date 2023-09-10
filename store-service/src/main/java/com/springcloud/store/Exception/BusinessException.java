package com.springcloud.store.Exception;

public class BusinessException extends RuntimeException {
	private ErrorCode errorCode;

public BusinessException(ErrorCode errorCode)
{
super(errorCode.getdesc());
this.errorCode=errorCode;
}
	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
