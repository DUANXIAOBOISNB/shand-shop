package com.springcloud.common.Vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
	@Builder.Default
	private Integer code=200;
	private String message;
	private T data;

}
