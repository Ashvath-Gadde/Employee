package com.employeeDetails.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeeDetails.demo.dao.EmployeeDao;
import com.employeeDetails.demo.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public List<Employee> getEmployees() {
		return dao.findAll();
	}
	
	@Override
	public Optional<Employee> getEmployeeById(int empid) {
		return dao.findById(empid);
	}
    
    @Override
    public Employee addNewEmployee(Employee emp) {
        return dao.save(emp);
    }
    
  
    @Override
    public void deleteEmployeeById(int empid) {
        dao.deleteById(empid);
    }
    
    @Override
    public void deleteAllEmployees() {
        dao.deleteAll();
    }

	@Override
	public Employee updateEmployee(Employee emp, int id) {
	Optional<Employee> optionalemployee=dao.findById(id);
	Employee e;

		e=optionalemployee.get();
		
		e.setFirstname(emp.getFirstname());
		e.setDob(emp.getDob());
		e.setLastName(emp.getLastName());
		e.setGender(emp.getGender());
		e.setPhoneNo(emp.getPhoneNo());
		e.setEmail(emp.getEmail());
		return dao.save(e);
	
	}

	public List<Employee> searchEmployee(String search) {
		List<Employee> e=dao.searchByName(search);
		return e;
	}

	public void deletebyemail(String email) {
		// TODO Auto-generated method stub
		dao.deleteByEmail(email);
	}
	

	
	

}
