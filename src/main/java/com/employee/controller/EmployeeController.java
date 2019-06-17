package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/rest")
public class EmployeeController {
	
	@Autowired EmployeeServiceInterface employeeServiceInterface;
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		return employeeServiceInterface.addEmployee(employee);
		
	}
	
	@PutMapping("/employee")
	public String getUpdate(@RequestBody Employee employee) {
		return employeeServiceInterface.updateEmployee(employee);
		
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int employeeId) {
		return employeeServiceInterface.getEmployeeById(employeeId);
		
	}
	@GetMapping("/employee/allEmployee")
	public List<Employee> getAllEmployee()
	{
		return employeeServiceInterface.getAllEmployee();
	}
	@DeleteMapping("/employee/deleteEmployee/{employeeId}")
	public List<Employee> deleteEmployee(@PathVariable("employeeId") int id)
	{
		return employeeServiceInterface.deleteEmployee(id);
	}

}
