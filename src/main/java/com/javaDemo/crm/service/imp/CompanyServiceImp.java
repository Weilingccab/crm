package com.javaDemo.crm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaDemo.crm.dao.CompanyDao;
import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.model.Company;
import com.javaDemo.crm.service.CompanyService;

@Service
public class CompanyServiceImp implements CompanyService{

	@Autowired
	private CompanyDao companyDao;
	
	
	@Override
	public List<CompanyDto> getCompanyList() {
		List<Company> list = companyDao.findAll();
		List<CompanyDto> dtoList = new ArrayList<>();
		for(Company c : list) {
			CompanyDto cdto = new CompanyDto(c.getId(),c.getName());
			cdto.setAddress(c.getAddress());
			dtoList.add(cdto);
		}
		
		return dtoList;
	}

}
