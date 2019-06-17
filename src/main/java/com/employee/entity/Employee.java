package com.employee.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Setter @Getter  @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "EMPLOYEE_DETAILS")
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int employeeId;
	private String employeeName;
	private String designation;
	private String address;
	private String mobile;
	private double salary;
	
	  public int getEmployeeId() { return employeeId; } public void
	  setEmployeeId(int employeeId) { this.employeeId = employeeId; } public String
	  getEmployeeName() { return employeeName; } public void setEmployeeName(String
	  employeeName) { this.employeeName = employeeName; } public String
	  getDesignation() { return designation; } public void setDesignation(String
	  designation) { this.designation = designation; } public String getAddress() {
	  return address; } public void setAddress(String address) { this.address =
	  address; } public String getMobile() { return mobile; } public void
	  setMobile(String mobile) { this.mobile = mobile; } public double getSalary()
	  { return salary; } public void setSalary(double salary) { this.salary =
	  salary; }
	 
	
	
	

}
