package com.javaDemo.crm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ClientDto", description = "客戶基礎資訊")
public class ClientDto {

	@ApiModelProperty(value = "客戶ID", required = true)
	private long id;
	
	@ApiModelProperty(value = "公司基礎資料", required = true)
	private CompanyDto companyDto;

	@ApiModelProperty(value = "客戶名稱", required = true)
	private String name;

	@ApiModelProperty(value = "客戶信箱", required = false)
	private String email;
	
	@ApiModelProperty(value = "客戶電話", required = false)
	private String phone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CompanyDto getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDto companyDto) {
		this.companyDto = companyDto;
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

	public ClientDto(long id, CompanyDto companyDto, String name, String email, String phone) {
		super();
		this.id = id;
		this.companyDto = companyDto;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
 
	 

}
