package com.javaDemo.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaDemo.crm.model.Company;

public interface CompanyDao extends JpaRepository<Company, Long> {

}