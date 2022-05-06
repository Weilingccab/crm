package com.javaDemo.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.dto.GeneralResult;
import com.javaDemo.crm.paramDto.ParamAddCompanyDto;
import com.javaDemo.crm.service.CompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "公司相關API")
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@ApiOperation(value = "獲取公司清單", notes = "獲取公司清單", response = CompanyDto.class, responseContainer = "List")
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<CompanyDto> getCompanyList() {
		List<CompanyDto> list = companyService.getCompanyList();
		return list;
	}

	@ApiOperation(value = "新增公司", notes = "新增公司", response = GeneralResult.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "paramAddCompanyDto", value = "欲新增公司資料", paramType = "body", required = true, dataType = "ParamAddCompanyDto"),

	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public GeneralResult addCompany(@RequestBody ParamAddCompanyDto paramAddCompanyDto) {
		GeneralResult g = companyService.addCompany(paramAddCompanyDto);
		return g;
	}

}
