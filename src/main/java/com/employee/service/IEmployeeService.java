package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface IEmployeeService {
	
	public String addEmployee(Employee employee);
	public String updateEmployee(Employee employee);
	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException;
	public List<Employee> getAllEmployees();
	public void deleteEmployee(int employeeId);

	

}
