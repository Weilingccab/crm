package com.javaDemo.crm.builder.imp;

import com.javaDemo.crm.builder.CompanyBuilder;
import com.javaDemo.crm.model.Company;

import io.swagger.annotations.ApiModelProperty;

public class CompanyBuilderFactory implements CompanyBuilder {

	private long id;
	private String name;
	private String address;
	private String createdBy;
	private String updatedBy;

	@Override
	public CompanyBuilder setId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public CompanyBuilder setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public CompanyBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	@Override
	public CompanyBuilder setCreateby(String username) {
		this.createdBy = username;
		return this;
	}

	@Override
	public CompanyBuilder setUpdateby(String username) {
		this.updatedBy = username;
		return this;
	}

	@Override
	public Company create() {
		return new Company(id, name, address, createdBy, updatedBy);
	}

}
