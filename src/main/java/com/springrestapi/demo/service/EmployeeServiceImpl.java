package com.springrestapi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	@Override
	public List<Employee> getEmployeesByName(String name) {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return eRpRepository.findByName(name,sort);
	}

	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		return eRpRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
		return eRpRepository.getEmployeesByNameOrLocation(name, location);
	}

	@Override
	public Integer deleteEmployeeByName(String name) {
		return eRpRepository.deleteEmployeeByName(name);
	}

	

}
