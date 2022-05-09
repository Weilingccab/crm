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
import com.javaDemo.crm.paramDto.ParamUpdateCompanyDto;
import com.javaDemo.crm.service.CompanyService;

@Service
public class CompanyServiceImp implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private UserDetailsServiceImp userDetailsServiceImp;

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
	public CompanyDto addCompany(ParamAddCompanyDto paramAddCompanyDto) {
		String username = userDetailsServiceImp.getCurrentUsername();
		Company c = new CompanyBuilderFactory().setName(paramAddCompanyDto.getName())
				.setAddress(paramAddCompanyDto.getAddress()).setCreateby(username).setUpdateby(username).create();
		Company dbCompany = companyDao.save(c);
		CompanyDto cdto = new CompanyDto(dbCompany.getId(), dbCompany.getName(), dbCompany.getAddress());
		return cdto;

	}

	@Override
	public CompanyDto getCompany(long id) {
		Company dbCompany = companyDao.findById(id);
		CompanyDto cdto = new CompanyDto(dbCompany.getId(), dbCompany.getName(), dbCompany.getAddress());
		return cdto;
	}

	@Override
	@Transactional
	public CompanyDto updateCompany(ParamUpdateCompanyDto paramUpdateCompanyDto) {
		String username = userDetailsServiceImp.getCurrentUsername();
		Company dbCompany = companyDao.findById(paramUpdateCompanyDto.getId());
		dbCompany.setName(paramUpdateCompanyDto.getName());
		dbCompany.setAddress(paramUpdateCompanyDto.getAddress());
		dbCompany.setUpdatedBy(username);
		Company dbFinCompany = companyDao.save(dbCompany);
		CompanyDto cdto = new CompanyDto(dbFinCompany.getId(), dbFinCompany.getName(), dbFinCompany.getAddress());
		return cdto;
	}

	@Override
	@Transactional
	public GeneralResult deleteCompany(long id) {
		companyDao.deleteById(id);
		GeneralResult gr = new GeneralResult(true, null);
		return gr;
	}

}
