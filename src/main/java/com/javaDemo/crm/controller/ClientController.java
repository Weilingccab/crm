package com.javaDemo.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaDemo.crm.dto.ClientDto;
import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.dto.GeneralResult;
import com.javaDemo.crm.paramDto.ParamAddClientDto;
import com.javaDemo.crm.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "客戶相關API")
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
 

	@ApiOperation(value = "新增多筆客戶", notes = "新增多筆客戶", response = Long.class,responseContainer = "List")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "paramAddClientDtoList", value = "欲新增客戶資料", paramType = "body", required = true, dataType = "ParamAddClientDto",allowMultiple = true) })
	@RequestMapping(value = "/add/many", method = RequestMethod.POST)
	public List<Long> addClient(@RequestBody List<ParamAddClientDto> paramAddClientDtoList) {
		List<Long> list = clientService.addClientList(paramAddClientDtoList);
		return list;
	}
	
	@ApiOperation(value = "獲取客戶清單", notes = "獲取客戶清單", response = CompanyDto.class, responseContainer = "List")
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<ClientDto> getCompanyList() {
		List<ClientDto> list = clientService.getClientList();
		return list;
	}
 
}
