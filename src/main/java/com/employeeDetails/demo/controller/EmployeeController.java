package com.employeeDetails.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
    		public Employee createEmployee(@Valid @RequestBody Employee newemp) {
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
    		
    
    // search via name
    		
    		@GetMapping("/getEmployeelike/{search}")
    		public List<Employee> employeesearch(@PathVariable String search) {
    			return service.searchEmployee(search);
    		}
    		
    		
    //Get male employees
    		
    		@GetMapping("/getMaleEmployee")
    		public List<Employee> retrieveMaleemployees() {
    		
    			
    		List<Employee> maleemployee	=service.getEmployees().stream()
    									 .filter(emp-> emp.getGender().equals("male"))
    								     .collect(Collectors.toList());
    			System.out.println("Male Employee count " +maleemployee.size());
    			return maleemployee; 
    		}
    		
    		
    //Get female employees
    		
    		@GetMapping("/getFemaleEmployee")
    		public List<Employee> retrieveFemaleemployees() {
    		
    			
    			List<Employee> femaleemployee	=service.getEmployees().stream()
    											 .filter(emp-> emp.getGender().equals("female"))
    											 .collect(Collectors.toList());
    			System.out.println("Female Employee count "+femaleemployee.size());
    			return femaleemployee; 
    		}
    		
    		
    //To Delete employee by email
    		
    		@DeleteMapping("/employeeemail/{email}")
    		public void deletebyemail(@PathVariable String email) {

    			service.deletebyemail(email);

    		}
    		
}

