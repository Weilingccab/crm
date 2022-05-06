package com.javaDemo.crm.builder;

import com.javaDemo.crm.model.Company;

public interface CompanyBuilder {
 
	public CompanyBuilder setId(long id);
	public CompanyBuilder setName(String name);
	public CompanyBuilder setAddress(String address);
	public CompanyBuilder setCreateby(String username);
	public CompanyBuilder setUpdateby(String username);
    public Company create();


}
