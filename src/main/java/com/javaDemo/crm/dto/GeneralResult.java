package com.javaDemo.crm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GeneralResult", description = "通用回傳資訊")
public class GeneralResult {

	@ApiModelProperty(value = "執行是否成功", required = true)
	private boolean isSuccess;
	
	@ApiModelProperty(value = "錯誤訊息", required = false)
	private String errorInfo;
	
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public GeneralResult(boolean isSuccess, String errorInfo) {
		super();
		this.isSuccess = isSuccess;
		this.errorInfo = errorInfo;
	}
	
	
	
}
