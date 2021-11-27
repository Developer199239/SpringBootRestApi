package com.springrestapi.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.springrestapi.demo.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// this all are JPA query 
	
	List<Employee> findByName(String name, Sort sort);
	
	//select * from table where name="name" and location="location"
	List<Employee> findByNameAndLocation(String name, String location);
	
	@Query("FROM Employee WHERE name = :name OR location = :location")
	List<Employee> getEmployeesByNameOrLocation(String name, String location);
	
	@Transactional 
	@Modifying // use for create,update, delete for jpa query
	@Query("DELETE FROM Employee WHERE name = :name")
	Integer deleteEmployeeByName(String name);

}
