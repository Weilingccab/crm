package com.javaDemo.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaDemo.crm.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}