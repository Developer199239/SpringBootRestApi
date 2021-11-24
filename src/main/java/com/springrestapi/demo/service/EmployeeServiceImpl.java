package com.springrestapi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.demo.model.Employee;
import com.springrestapi.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository eRpRepository;
	
	@Override
	public List<Employee> getEmployees() {
		return eRpRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return eRpRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee = eRpRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for the id "+id);
	}

	@Override
	public void deleteEmployee(Long id) {
		eRpRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return eRpRepository.save(employee);
	}

	

}
