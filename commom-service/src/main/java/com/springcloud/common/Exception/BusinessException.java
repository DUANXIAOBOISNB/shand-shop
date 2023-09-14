package com.springcloud.common.Exception;

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
