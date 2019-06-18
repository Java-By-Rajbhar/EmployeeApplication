package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeRepository employeRepository;

	@Override
	public String addEmployee(Employee employee) {
		if (employeRepository.save(employee) == null)
			return "employee not created";
		else
			return employee.getEmployeeId() + " employee succesessfully created";
	}

	@Override
	public String updateEmployee(Employee employee) {

		if (employeRepository.getOne(employee.getEmployeeId()) != null) {
			if (employeRepository.save(employee) == null)
				return "employee not updated";
			else
				return "employee updated succeseefully";
		} else {
			return "employee not existed";
		}
	}

	@Override
	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException {

		Employee employee = employeRepository.findByEmployeeId(employeeId);
		if (employee == null) {
			System.out.println(" from service impl employee object : " + employee);
			throw new EmployeeNotFoundException("Employee Not Found in the database");
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int employeeId) {

		if (employeRepository.findByEmployeeId(employeeId) != null) {
			employeRepository.deleteById(employeeId);
		}

	}

}
