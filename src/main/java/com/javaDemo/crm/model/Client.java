package com.javaDemo.crm.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "CLIENT")
@NamedEntityGraph(
		  name = "client.company",
		  attributeNodes = {
		    @NamedAttributeNode("company")		  }
		)
public class Client {

	@Column(name = "ID", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;



	@ManyToOne(targetEntity = Company.class,fetch = FetchType.LAZY)
	@JoinColumns(value = { @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID", nullable = false) })
	private Company company;

	@Column(name = "NAME", length = 15, nullable = false)
	private String name;

	@Column(name = "EMAIL", length = 500, nullable = true)
	private String email;

	@Column(name = "PHONE", length = 50, nullable = true)
	private String phone;

	@Column(name = "CREATED_BY", nullable = false, insertable = true, updatable = false)
	private String createdBy;

	@Column(name = "CREATED_AT", nullable = false, insertable = true, updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "UPDATE_BY", nullable = false, insertable = true, updatable = true)
	private String updatedBy;

	@Column(name = "UPDATE_AT", nullable = false, insertable = true, updatable = true)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@PrePersist
	void createDate() {
		long time = new Date().getTime();
		this.createdAt = this.updatedAt = new Timestamp(time);
	}

	@PreUpdate
	void updateDate() {
		long time = new Date().getTime();
		this.updatedAt = new Timestamp(time);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Client(long id, Company company, String name, String email, String phone, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.company = company;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Client() {
		super();
	}

	
}
