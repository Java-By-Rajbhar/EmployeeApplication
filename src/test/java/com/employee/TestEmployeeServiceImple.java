package com.employee;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.employee.entity.Employee;
import com.employee.repository.EmployeRepository;
//import com.employee.service.EmployeeNotFoundException;
import com.employee.service.EmployeeService;
import com.employee.service.IEmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeServiceImple {

	@Mock
	EmployeRepository employee;
	@InjectMocks
	EmployeeService employeeService;

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
		String actualvalue = employeeService.addEmployee(employee1);
		Assert.assertEquals(actualvalue, "2 employee succesessfully created");

	}

	/*
	 * @Test public void testGetEmployeeById() throws EmployeeNotFoundException {
	 * 
	 * Employee employee1 = new Employee(); employee1.setAddress("address");
	 * employee1.setDesignation("designation"); employee1.setEmployeeId(1);
	 * employee1.setEmployeeName("kusuma bk"); employee1.setMobile("9999999");
	 * employee1.setSalary(100000);
	 * 
	 * Mockito.when(employee.findByEmployeeId(employee1.getEmployeeId())).thenReturn
	 * (employee1); //
	 * Mockito.when(employee.findByEmployeeId(1)).thenReturn(employee1); Employee
	 * actualvalue = employeeService.getEmployeeById(employee1.getEmployeeId());
	 * Assert.assertEquals(actualvalue, employee1);
	 * 
	 * }
	 */

	@Test
	public void testUpdateEmployee() {
		Employee employee1 = new Employee();
		employee1.setAddress("address");
		employee1.setDesignation("des");
		employee1.setEmployeeId(4);
		employee1.setEmployeeName("ertw");
		employee1.setMobile("45543");
		employee1.setSalary(10000);
		
//		Mockito.when(employee.findByEmployeeId(employee1.getEmployeeId())).thenReturn(employee1);
		Mockito.when(employee.save(employee1)).thenReturn(employee1);

		String actualvalue = employeeService.updateEmployee(employee1);
		System.out.println(actualvalue);
		Assert.assertEquals(actualvalue, "");
	}

	 @Test
	  public void testGetAllEmployee() {
	  
	  Employee employee1 = new Employee(); employee1.setAddress("banglore");
	  employee1.setDesignation("SE"); employee1.setEmployeeId(1);
	  employee1.setEmployeeName("kusuma bk"); employee1.setMobile("9999999");
	  employee1.setSalary(100000);
	  
	  Employee employee2 = new Employee(); employee1.setAddress("address");
	  employee1.setDesignation("designation"); employee1.setEmployeeId(1);
	  employee1.setEmployeeName("kusuma bk"); employee1.setMobile("9999999");
	  employee1.setSalary(100000);
	  
	  List <Employee> employeeList=new ArrayList<>();
	  employeeList.add(employee1);
	  employeeList.add(employee2);

	  Mockito.when(employee.findAll()).thenReturn(employeeList); //
//	  Mockito.when(employee.findByEmployeeId(1)).thenReturn(employee1); Employee
	  List<Employee> actualvalue = employeeService.getAllEmployees();
	  Assert.assertEquals(actualvalue, employeeList);
	  
	  }
	 
	 
	/*
	 * @Test public void testDeleteEmployee() {
	 * 
	 * Employee employee1 = new Employee(); employee1.setAddress("address");
	 * employee1.setDesignation("designation"); employee1.setEmployeeId(2);
	 * employee1.setEmployeeName("kusuma bk"); employee1.setMobile("9999999");
	 * employee1.setSalary(100000);
	 * 
	 * Mockito.when(employee.deleteById(employee1.getEmployeeId())).thenReturn(
	 * employee1); String actualvalue =
	 * employeeService.deleteEmployee(employee1.getEmployeeId());
	 * Assert.assertEquals(actualvalue, "2 employee succesessfully created");
	 * 
	 * }
	 */

}
