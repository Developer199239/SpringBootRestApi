package com.springrestapi.demo.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name = "id")
	public Long id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "age")
	public Long age;

	@Column(name = "location")
	public String location;

	@Column(name = "email")
	public String email;

	@Column(name = "department")
	public String department;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	public Date createdAt;
	
	@CreationTimestamp
	@Column(name = "updated_at")
	public Date updatedAt;
}
