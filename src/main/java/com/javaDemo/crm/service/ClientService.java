package com.javaDemo.crm.service;

import java.util.List;

import com.javaDemo.crm.dto.ClientDto;
import com.javaDemo.crm.paramDto.ParamAddClientDto;

public interface ClientService {
 
 
	List<Long> addClientList(List<ParamAddClientDto> paramAddClientDtoList);

	List<ClientDto> getClientList();

}