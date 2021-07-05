package com.employeeDetails.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="employee_tbl")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer empid;
	
	@NotEmpty
	@NotNull(message = "firstname is mandatory")
	private String firstname;
	
	@NotEmpty
	@NotNull(message = "lastName is mandatory")
	private String lastName;
	
	@NotEmpty
	@NotNull(message = "gender is mandatory")
	private String gender;
	
	@NotEmpty
	@NotNull(message = "dob is mandatory")
	private String dob;
	
	@NotEmpty
	@NotNull(message = "phoneNo is mandatory")
	private String phoneNo;

	@NotEmpty
	@Email
	@NotNull(message = "emailId is mandatory")
	private String email;
	
	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstname=" + firstname + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}

	
	
	
}
