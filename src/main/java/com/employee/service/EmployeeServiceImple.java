package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeRepo;

@Service
public class EmployeeServiceImple implements EmployeeServiceInterface {

	@Autowired
	EmployeRepo employeRepo;

	@Override
	public String addEmployee(Employee employee) {
		if (employeRepo.save(employee) == null)
			return "employee not created";
		else
			return employee.getEmployeeId() + " employee succesessfully created";
	}

	@Override
	public String updateEmployee(Employee employee) {

		if (employeRepo.getOne(employee.getEmployeeId()) != null) {
			if (employeRepo.save(employee) == null)
				return "employee not updated";
			else
				return "employee updated succeseefully";
		} else {
			return "employee not existed";
		}
	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		Employee employee = employeRepo.findByEmployeeId(employeeId);
		if (employee == null) {
			System.out.println(" from service impl employee object : " + employee);
			return employee;
		} else
			return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeRepo.findAll();
	}

	@Override
	public List<Employee> deleteEmployee(int employeeId) {
		
		if(employeRepo.findByEmployeeId(employeeId)!=null) 
		employeRepo.deleteById(employeeId);
		
		return employeRepo.findAll();
	}

}
