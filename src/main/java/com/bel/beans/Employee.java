package com.bel.beans;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import com.bel.beans.EmployeeGroupValidation.OnCreate;
import com.bel.beans.EmployeeGroupValidation.OnDelete;
import com.bel.beans.EmployeeGroupValidation.OnUpdate;




public class Employee{
	
	@NotNull(groups = {OnUpdate.class, OnDelete.class}, message = "Id must not be null")
	@Range(min = 1, max = 100, message = "Employee ID should be Min 1 and Max 100", groups = {OnUpdate.class, OnDelete.class})
	private Integer id;
	
	@NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "name must not be null")
	@Size(min = 4, max = 10, message = "Name should be Min 4 and Max 10 characters")
	private String name;
	
	@NotNull(groups = {OnCreate.class,OnUpdate.class}, message = "salary must not be null")
	private Double salary;
	
	@NotNull(groups = {OnCreate.class,OnUpdate.class}, message = "sex must not be null")
	private String sex;
	
	@NotNull(groups = {OnCreate.class,OnUpdate.class}, message = "age must not be null")
	private Integer age;
	
	@Valid
	@NotNull(groups = {OnCreate.class,OnUpdate.class})
	@NotEmpty(groups = {OnCreate.class,OnUpdate.class})
	private List<@Size(groups = {OnCreate.class,OnUpdate.class}, min = 4, max = 25, message = "Email ID should be min 4 and max 25 characters")
	@Email(groups = {OnCreate.class,OnUpdate.class}, message = "Not a Valid Email ID") 
	String> emailIdList;
	
	@Valid
	@NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "Department cannot be null")
	private Department department;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List<String> getEmailIdList() {
		return emailIdList;
	}
	public void setEmailIdList(List<String> emailIdList) {
		this.emailIdList = emailIdList;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
	

	
}
