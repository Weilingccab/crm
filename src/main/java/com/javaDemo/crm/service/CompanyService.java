package com.javaDemo.crm.service;

import java.util.List;

import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.dto.GeneralResult;
import com.javaDemo.crm.paramDto.ParamAddCompanyDto;

public interface CompanyService {

	List<CompanyDto> getCompanyList();
	
	GeneralResult addCompany(ParamAddCompanyDto paramAddCompanyDto);
 
}