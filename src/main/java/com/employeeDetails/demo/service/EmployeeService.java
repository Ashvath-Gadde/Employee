package com.employeeDetails.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employeeDetails.demo.model.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getEmployees();

	public Optional<Employee> getEmployeeById(int empid);
	
	public Employee addNewEmployee(Employee emp);

	public Employee updateEmployee(Employee emp, int id);

	public void deleteEmployeeById(int empid);

	public void deleteAllEmployees();
	

	   
}
