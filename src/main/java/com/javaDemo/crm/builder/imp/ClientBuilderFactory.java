package com.javaDemo.crm.builder.imp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.javaDemo.crm.builder.ClientBuilder;
import com.javaDemo.crm.builder.CompanyBuilder;
import com.javaDemo.crm.model.Client;
import com.javaDemo.crm.model.Company;

import io.swagger.annotations.ApiModelProperty;

public class ClientBuilderFactory implements ClientBuilder {

	private long id;
	private String name;
	private String email;
	private String phone;
	private Company company;
	private String createdBy;
	private String updatedBy;

	@Override
	public ClientBuilder setId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public ClientBuilder setCompany(Company company) {
		this.company = company;
		return this;
	}

	@Override
	public ClientBuilder setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public ClientBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public ClientBuilder setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	@Override
	public ClientBuilder setCreateby(String username) {
		this.createdBy = username;
		return this;
	}

	@Override
	public ClientBuilder setUpdateby(String username) {
		this.updatedBy = username;
		return this;
	}

	@Override
	public Client create() {
		return new Client(id, company, name, email, phone, createdBy, updatedBy);
	}

}
