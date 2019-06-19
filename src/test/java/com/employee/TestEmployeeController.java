package com.employee;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employee.controller.EmployeeController;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
//@WebAppConfiguration
public class TestEmployeeController {
	
	@InjectMocks
	private EmployeeController employeeController;
	
	private MockMvc mockmvc;
	
	@Mock
	private EmployeeService employeeService;
	
	Employee employee;
	
	
	@Before
	public void setUp() throws Exception{
		
		mockmvc=MockMvcBuilders.standaloneSetup(employeeController).build();
		
		 employee=new Employee();
		   employee.setAddress("address");
		   employee.setDesignation("designation");
		   employee.setEmployeeId(1);
		   employee.setEmployeeName("name");
		   employee.setMobile("99999999");
		   employee.setSalary(200d);
		
		/*
		 * employee.setAddress("banglore"); employee.setDesignation("SSE");
		 * employee.setEmployeeId(1); employee.setEmployeeName("kusuma");
		 * employee.setMobile("999999"); employee.setSalary(5000000000D);
		 */
		 
	}
	
	@Test
	public void testGetAll() throws Exception {
//		mockmvc.perform(MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		mockmvc.perform(MockMvcRequestBuilders.get("/rest/employees")).andExpect(status().isOk());
//		mockmvc.perform(MockMvcRequestBuilders.get("/rest/employees").content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON)).andExpect()

	}
	
	
	  @Test
	  public void testaddEmployee() throws Exception {
		   
	  mockmvc.perform(MockMvcRequestBuilders.post("/rest/employee").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());
	  
	  }
	  
	  
	  
	  @Test
	  public void testGetEmployee() throws Exception {
		   
	  mockmvc.perform(MockMvcRequestBuilders.get("/rest/employee/{employeeId}",1).contentType(MediaType.ALL).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());
	  
	  }
	 
	  @Test
	  public void testUpdateEmployee() throws Exception {
		   
	  mockmvc.perform(MockMvcRequestBuilders.put("/rest/employee").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(asJsonString(employee))).andExpect(status().isOk());
	  
	  }
	
	  
	  @Test
	  public void testDeleteEmployee() throws Exception {
		   
	  mockmvc.perform(MockMvcRequestBuilders.delete("/rest/employee/{employeeId}",1).contentType(MediaType.ALL).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());
	  
	  }
	  
	  
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
