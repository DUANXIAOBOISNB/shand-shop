package com.springcloud.store.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorRestResult {
private String errorcode;
private String msg;

}
