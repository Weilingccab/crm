package com.javaDemo.crm.paramDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ParamAddClientDto", description = "新增客戶基礎資訊")
public class ParamAddClientDto { 
	
	@ApiModelProperty(value = "公司基礎資料", required = true)
	private long companyId;

	@ApiModelProperty(value = "客戶名稱", required = true)
	private String name;

	@ApiModelProperty(value = "客戶信箱", required = false)
	private String email;
	
	@ApiModelProperty(value = "客戶電話", required = false)
	private String phone;

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
 
	 

}
