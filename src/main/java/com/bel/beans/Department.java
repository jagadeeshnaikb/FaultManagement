package com.bel.beans;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.bel.beans.EmployeeGroupValidation.OnCreate;
import com.bel.beans.EmployeeGroupValidation.OnDelete;
import com.bel.beans.EmployeeGroupValidation.OnDepartmentCreate;
import com.bel.beans.EmployeeGroupValidation.OnDepartmentUpdate;
import com.bel.beans.EmployeeGroupValidation.OnUpdate;

public class Department {
	
	@NotNull(groups = {OnCreate.class, OnUpdate.class, OnDepartmentUpdate.class, OnDelete.class}, message = "Department ID cannot be null")
	@Range(groups = OnCreate.class, min = 1, max = 10, message = "Department Id should be Min 1 and Max 10")
	private Integer id;
	
	@NotNull(groups = {OnDepartmentCreate.class, OnDepartmentUpdate.class}, message = "Department Name cannot be null")
	@Size(groups = {OnDepartmentCreate.class, OnDepartmentUpdate.class}, min = 4, max = 25,  message = "Department Name Min 4 and Max 25 characters")
	private String name;
	
	@NotNull(groups = {OnDepartmentCreate.class, OnDepartmentUpdate.class}, message = "HOD cannot be null")
	@Size(groups = {OnDepartmentCreate.class, OnDepartmentUpdate.class}, min = 4, max = 15,  message = "HOD Min 4 and Max 15 characters")
	private String hod;
	
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
	public String getHod() {
		return hod;
	}
	public void setHod(String hod) {
		this.hod = hod;
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
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
