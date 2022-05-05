package com.javaDemo.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.service.CompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "公司相關API")
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	
	@ApiOperation(value = "獲取公司清單", notes = "獲取公司清單", response = CompanyDto.class, responseContainer = "List")
	@RequestMapping(value = "/get/companyList", method = RequestMethod.GET)
	public List<CompanyDto> getCompanyList() {
		List<CompanyDto> list = companyService.getCompanyList();
		return list;
	}

	@ApiOperation(value = "update公司清單", notes = "獲取公司清單", response = Boolean.class)
	@RequestMapping(value = "/update/companyList", method = RequestMethod.GET)
	public Boolean updateTest() {
 		return true;
	}

}
