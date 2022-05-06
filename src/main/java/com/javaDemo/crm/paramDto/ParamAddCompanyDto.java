package com.javaDemo.crm.paramDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ParamAddCompanyDto", description = "新增公司資訊")
public class ParamAddCompanyDto {

	@ApiModelProperty(value = "公司名稱", required = true)
	private String name;

	@ApiModelProperty(value = "公司地址", required = false)
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
