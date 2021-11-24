package com.springrestapi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.demo.model.Employee;
import com.springrestapi.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return eService.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return eService.getSingleEmployee(id);
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return eService.saveEmployee(employee);
	}
	
	@PutMapping("employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.id = id;
		return eService.updateEmployee(employee);
	}

	@DeleteMapping("/employees")
	public void deleteEmployee(@RequestParam("id") Long id) {
		eService.deleteEmployee(id);
	}


}
