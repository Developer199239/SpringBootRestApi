package com.springrestapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
