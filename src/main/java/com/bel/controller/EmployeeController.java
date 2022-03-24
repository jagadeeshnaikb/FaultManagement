package com.bel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bel.beans.Employee;
import com.bel.beans.EmployeeGroupValidation.OnCreate;
import com.bel.beans.EmployeeGroupValidation.OnDelete;
import com.bel.beans.EmployeeGroupValidation.OnUpdate;
import com.bel.service.EmployeeService;

@RestController
@Validated
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value = "/getAllEmployees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}

	@PostMapping(value = "/addEmployee")
	public Employee addEmployee(@Validated(OnCreate.class) @RequestBody Employee employee)
	{
		Employee emp = employeeService.addEmployee(employee);
		return emp;
	}
	
	@PostMapping(value = "/updateEmployee")
	public Employee updateEmployee(@Validated(OnUpdate.class) @RequestBody Employee employee)
	{
		Employee emp = employeeService.updateEmployee(employee);
		return emp;
	}
	
	@PostMapping(value = "/deleteEmployee/{empId}")
	public boolean deleteEmployeePathVariable(@Validated(OnDelete.class) @PathVariable int empId)
	{
		return employeeService.deleteEmployee(empId);
	}
	
	@PostMapping(value = "/deleteEmployee")
	public boolean deleteEmployeeReqBody(@Validated(OnDelete.class)  @RequestBody Employee employee)
	{
		return employeeService.deleteEmployee(employee);
	}
}
