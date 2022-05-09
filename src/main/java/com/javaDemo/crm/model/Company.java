package com.javaDemo.crm.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "COMPANY")
public class Company {

	@Column(name = "ID", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME", length = 15, nullable = false)
	private String name;

	@Column(name = "ADDRESS", length = 1000, nullable = true)
	private String address;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	
	  public Company(){}


	public Company(long id, String name, String address, String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

}
