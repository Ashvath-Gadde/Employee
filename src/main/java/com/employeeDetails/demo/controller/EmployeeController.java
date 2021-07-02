package com.employeeDetails.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employeeDetails.demo.model.Employee;
import com.employeeDetails.demo.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
    EmployeeService service;
 
	
	// To get all employees
	
    		@GetMapping("/getAll")
    		public List<Employee> getEmployees() {
        	List<Employee> employees=service.getEmployees();
        	return employees;
    }
 
    // To get employee by id 
    		
    		@GetMapping("/employee/{id}")
    		public Employee getEmployeeById(@PathVariable int id) {
        	Optional<Employee> emp =  service.getEmployeeById(id);
        	return emp.get();
    }
 
    // To insert employee details
    		
    		@PostMapping("/employee/add")
    		public Employee createEmployee(@RequestBody Employee newemp) {
        	return service.addNewEmployee(newemp);
    }
 
    // To update employee details
    		
    		@PutMapping("/employee/update/{id}")
    		public Employee updateEmployee(@RequestBody Employee updemp, @PathVariable int id) {
        	return service.updateEmployee(updemp,id);
    }	
 
    		
    // To Delete employee details by id
    		
    		@DeleteMapping("/employee/delete/{id}")
    		public void deleteEmployeeById(@PathVariable int id) {
        	service.deleteEmployeeById(id);
    }
 
    		
    // To delete all employee details
    		
    		@DeleteMapping("/employee/deleteall")
    		public void deleteAll() {
        	service.deleteAllEmployees();
    }
}

