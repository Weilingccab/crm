package com.javaDemo.crm.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaDemo.crm.builder.imp.ClientBuilderFactory;
import com.javaDemo.crm.builder.imp.CompanyBuilderFactory;
import com.javaDemo.crm.dao.ClientDao;
import com.javaDemo.crm.dto.ClientDto;
import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.model.Client;
import com.javaDemo.crm.paramDto.ParamAddClientDto;
import com.javaDemo.crm.service.ClientService;

@Service
public class ClientServiceImp implements ClientService {

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private UserDetailsServiceImp userDetailsServiceImp;

	@Override
	@Transactional
	public List<Long> addClientList(List<ParamAddClientDto> paramAddClientDtoList) {

		String username = userDetailsServiceImp.getCurrentUsername();

		List<Client> clientList = paramAddClientDtoList.stream()
				.map(p -> new ClientBuilderFactory().setEmail(p.getEmail()).setName(p.getName())
						.setCompany(new CompanyBuilderFactory().setId(p.getCompanyId()).create()).setPhone(p.getPhone())
						.setCreateby(username).setUpdateby(username).create())
				.collect(Collectors.toList());
		List<Client> dbClientList = clientDao.saveAll(clientList);

		List<Long> clientIdList = dbClientList.stream()
				.map(p -> p.getId())
				.collect(Collectors.toList());
		return clientIdList;
	}

	@Override
	public List<ClientDto> getClientList() {
		List<Client> list = clientDao.findAll();
		for (Client c : list) {
			System.out.println(c.getCompany().getAddress());
		}
		List<ClientDto> clientDtoList = list.stream()
				.map(p -> new ClientDto(p.getId(),
						new CompanyDto(p.getCompany().getId(), p.getCompany().getName(), p.getCompany().getAddress()),
						p.getName(), p.getEmail(), p.getPhone()))
				.collect(Collectors.toList());
		return clientDtoList;
	}

}
