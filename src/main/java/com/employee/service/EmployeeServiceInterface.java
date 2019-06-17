package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeServiceInterface {
	
	public String addEmployee(Employee employee);
	public String updateEmployee(Employee employee);
	public Employee getEmployeeById(int employeeId);
	public List<Employee> getAllEmployee();
	public List<Employee> deleteEmployee(int employeeId);

	

}
