package com.employeeDetails.demo.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.employeeDetails.demo.model.Employee;



@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	
	@Query("FROM Employee crudemp WHERE crudemp.firstname LIKE %:search%")
	List<Employee> searchByName(@Param("search") String search);

	@Modifying
	@Query("DELETE FROM Employee emp WHERE emp.email=:email")
	void deleteByEmail(@Param("email")String email);


}
