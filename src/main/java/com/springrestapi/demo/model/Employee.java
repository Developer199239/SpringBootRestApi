package com.springrestapi.demo.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull(message = "Name should not be null")
	public String name;
	
	
	public Long age = 0L;


	public String location;

	@Email(message = "Please enter the valid email address")
	public String email;

	@NotNull(message = "Department should not be null")
	public String department;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	public Date createdAt;
	
	@CreationTimestamp
	@Column(name = "updated_at")
	public Date updatedAt;
}
