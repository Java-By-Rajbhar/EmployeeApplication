package com.employee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.employee.entity.Employee;
import com.employee.repository.EmployeRepo;
import com.employee.service.EmployeeServiceImple;
import com.employee.service.EmployeeServiceInterface;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeServiceImple {

	@Mock
	EmployeRepo employee;
	@InjectMocks
	EmployeeServiceImple employeeServiceImple;

	@Test
	public void testAddEmployee() {

		Employee employee1 = new Employee();
		employee1.setAddress("address");
		employee1.setDesignation("designation");
		employee1.setEmployeeId(2);
		employee1.setEmployeeName("kusuma bk");
		employee1.setMobile("9999999");
		employee1.setSalary(100000);

		Mockito.when(employee.save(employee1)).thenReturn(employee1);
		String actualvalue = employeeServiceImple.addEmployee(employee1);
		Assert.assertEquals(actualvalue, "2 employee succesessfully created");

	}

	@Test
	public void testGetEmployeeById() {

		Employee employee1 = new Employee();
		employee1.setAddress("address");
		employee1.setDesignation("designation");
		employee1.setEmployeeId(1);
		employee1.setEmployeeName("kusuma bk");
		employee1.setMobile("9999999");
		employee1.setSalary(100000);

		Mockito.when(employee.findByEmployeeId(employee1.getEmployeeId())).thenReturn(employee1);
//		Mockito.when(employee.findByEmployeeId(1)).thenReturn(employee1);
		Employee actualvalue = employeeServiceImple.getEmployeeById(employee1.getEmployeeId());
		Assert.assertEquals(actualvalue, employee1);

	}

	@Test
	public void testUpdateEmployee() {
		Employee employee1 = new Employee();
		employee1.setAddress("address");
		employee1.setDesignation("des");
		employee1.setEmployeeId(4);
		employee1.setEmployeeName("ertw");
		employee1.setMobile("45543");
		employee1.setSalary(10000);
		
		Mockito.when(employee.findByEmployeeId(employee1.getEmployeeId())).thenReturn(employee1);
		Mockito.when(employee.save(employee1)).thenReturn(employee1);

		String actualvalue = employeeServiceImple.updateEmployee(employee1);
		System.out.println(actualvalue);
		Assert.assertEquals(actualvalue, "");
	}

	// @Test
	/*
	 * public void testGetAllEmployee() {
	 * 
	 * Employee employee1 = new Employee(); employee1.setAddress("address");
	 * employee1.setDesignation("designation"); employee1.setEmployeeId(1);
	 * employee1.setEmployeeName("kusuma bk"); employee1.setMobile("9999999");
	 * employee1.setSalary(100000);
	 * 
	 * Mockito.when(employee.findAll(employee1.getEmployeeId())).thenReturn(
	 * employee1); //
	 * Mockito.when(employee.findByEmployeeId(1)).thenReturn(employee1); Employee
	 * actualvalue =
	 * employeeServiceImple.getEmployeeById(employee1.getEmployeeId());
	 * Assert.assertEquals(actualvalue, employee1);
	 * 
	 * }
	 */

}
