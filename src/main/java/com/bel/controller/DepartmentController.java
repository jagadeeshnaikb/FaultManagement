package com.bel.controller;

import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bel.beans.Department;
import com.bel.beans.EmployeeGroupValidation.OnCreate;
import com.bel.beans.EmployeeGroupValidation.OnDelete;
import com.bel.beans.EmployeeGroupValidation.OnDepartmentCreate;
import com.bel.beans.EmployeeGroupValidation.OnDepartmentUpdate;
import com.bel.beans.EmployeeGroupValidation.OnUpdate;
import com.bel.service.DepartmentService;

@RestController
@Validated
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;

	@PostMapping("/addDepartment")
	public Department addDepartment(@Validated(OnDepartmentCreate.class) @RequestBody Department department)
	{
		return departmentService.addDepartment(department);
	}
	
	@PostMapping("/updateDepartment")
	public boolean updateDepartment(@Validated(OnDepartmentUpdate.class) @RequestBody Department department)
	{
		return departmentService.updateDepartment(department);
	}
	
	@PostMapping("/deleteDepartment")
	public boolean deleteDepartment(@Validated(OnDelete.class) @RequestBody Department department)
	{
		return departmentService.deleteDepartment(department);
	}
	
	@PostMapping("/deleteDepartment/{id}")
	public boolean deleteDepartmentPathVariable(@Range(min = 1, max = 10) @PathVariable Integer id)
	{
		return departmentService.deleteDepartment(id);
	}
	
	@GetMapping("/getAllDepartment")
	public List<Department> getAllDepartment()
	{
		return departmentService.getAllDepartment();
	}
	
	
	
}
