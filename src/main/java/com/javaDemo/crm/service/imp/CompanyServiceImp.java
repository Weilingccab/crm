package com.javaDemo.crm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaDemo.crm.builder.imp.CompanyBuilderFactory;
import com.javaDemo.crm.dao.CompanyDao;
import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.dto.GeneralResult;
import com.javaDemo.crm.model.Company;
import com.javaDemo.crm.paramDto.ParamAddCompanyDto;
import com.javaDemo.crm.service.CompanyService;

@Service
public class CompanyServiceImp implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	public List<CompanyDto> getCompanyList() {
		List<Company> list = companyDao.findAll();
		List<CompanyDto> dtoList = new ArrayList<>();
		for (Company c : list) {
			CompanyDto cdto = new CompanyDto(c.getId(), c.getName(), c.getAddress());
			dtoList.add(cdto);
		}

		return dtoList;
	}

	@Override
	@Transactional
	public GeneralResult addCompany(ParamAddCompanyDto paramAddCompanyDto) {
		String username = userDetailsServiceImpl.getCurrentUsername();
		Company c = new CompanyBuilderFactory().setName(paramAddCompanyDto.getName())
				.setAddress(paramAddCompanyDto.getAddress()).setCreateby(username).setUpdateby(username).create();
		try {
			companyDao.save(c);
			GeneralResult g = new GeneralResult(true,null);
			return g;
		} catch (Exception e) {
			GeneralResult g = new GeneralResult(false, e.toString());
			return g;
		}
	}

}
