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
import com.employee.service.EmployeeNotFoundException;
import com.employee.service.IEmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeController {

	@Autowired
	IEmployeeService iEmployeeService;

	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		return iEmployeeService.addEmployee(employee);

	}

	@PutMapping("/employee")
	public String updateEmployee(@RequestBody Employee employee) {
		return iEmployeeService.updateEmployee(employee);

	}

	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") int employeeId) throws EmployeeNotFoundException {
		return iEmployeeService.getEmployeeById(employeeId);

	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return iEmployeeService.getAllEmployees();
	}

	@DeleteMapping("/employee/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
		 iEmployeeService.deleteEmployee(employeeId);
	}

}
