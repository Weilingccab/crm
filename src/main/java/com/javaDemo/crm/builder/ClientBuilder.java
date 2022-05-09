package com.javaDemo.crm.builder;

import com.javaDemo.crm.model.Client;
import com.javaDemo.crm.model.Company;

public interface ClientBuilder {
 
	public ClientBuilder setId(long id);
	public ClientBuilder setCompany(Company company);
	public ClientBuilder setName(String name);
	public ClientBuilder setEmail(String email);
	public ClientBuilder setPhone(String phone);
	public ClientBuilder setCreateby(String createdBy);
	public ClientBuilder setUpdateby(String updatedBy);
    public Client create();


}
