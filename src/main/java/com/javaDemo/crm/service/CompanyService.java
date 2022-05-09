package com.javaDemo.crm.service;

import java.util.List;

import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.dto.GeneralResult;
import com.javaDemo.crm.paramDto.ParamAddCompanyDto;
import com.javaDemo.crm.paramDto.ParamUpdateCompanyDto;

public interface CompanyService {

	List<CompanyDto> getCompanyList();
	
	CompanyDto getCompany(long id);
 
	CompanyDto addCompany(ParamAddCompanyDto paramAddCompanyDto);

	CompanyDto updateCompany(ParamUpdateCompanyDto paramUpdateCompanyDto);

	GeneralResult deleteCompany(long id);

}