package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeResourceNotFoundException;
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
	public Employee getEmployeeById(int employeeId) {
		try {

			Optional<Employee> employee = employeRepository.findByEmployeeId(employeeId);
			if (employee.isPresent()) {
				return employee.get();
			} else {
				throw new EmployeeResourceNotFoundException("Employee not found");
			}
		} catch (Exception e) {
			throw new EmployeeResourceNotFoundException(e.getMessage());

		}

	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int employeeId)  {

		try {
		if (employeRepository.findByEmployeeId(employeeId) != null) {
			employeRepository.deleteById(employeeId);
		} else {
			throw new EmployeeResourceNotFoundException("Employee id " + employeeId + " does not exists in  database");
		}
		}catch(Exception e) {
			throw new EmployeeResourceNotFoundException("Employee id " + employeeId + " does not exists in  database");
		}

	}

}
