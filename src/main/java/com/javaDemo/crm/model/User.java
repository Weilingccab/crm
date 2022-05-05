package com.javaDemo.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USERNAME", nullable = false)	
	private String username;

	@Column(name = "PASSWORD", length = 255, nullable = false)
	private String password;

	@Column(name = "ROLES", length = 255, nullable = false)
	private  String roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	

}
