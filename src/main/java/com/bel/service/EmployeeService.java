package com.bel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bel.beans.Department;
import com.bel.beans.Employee;
import com.bel.dao.EmployeeRepository;
import com.bel.entity.EmployeeTable;

@Service
public class EmployeeService {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private List<Employee> employeeList = new ArrayList<>();
	private int count = 0;

	public Employee addEmployee(Employee employee)
	{
		/*if(employee.getId() == null)
		{
			count++;
			employee.setId(count);
			Department department = departmentService.findDepartment(employee.getDepartment().getId());
			employee.setDepartment(department);
		}
		employeeList.add(employee);
		return employee;*/
		
		EmployeeTable emp = new EmployeeTable();
		emp.setAge(employee.getAge());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setSex(employee.getSex());
		
		EmployeeTable empSaved =  employeeRepository.save(emp);
		employee.setId(empSaved.getId());
		return employee;
		
	}
	
	public Employee findEmployee(Employee emp)
	{
		Employee empFound = null;
		if(employeeList.contains(emp))
		{
			empFound = employeeList.get(employeeList.indexOf(emp));
		}
		return empFound;
	}
	
	public Employee updateEmployee(Employee employee)
	{
		/* Employee empFound = findEmployee(employee);
		if(empFound != null)
		{
		
			Department department = departmentService.findDepartment(employee.getDepartment().getId());
			employee.setDepartment(department);
			
			employeeList.set(employeeList.indexOf(employee), employee);
			
		}
		
		return employee; */
		
		EmployeeTable emp = new EmployeeTable();
		emp.setId(employee.getId());
		emp.setAge(employee.getAge());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setSex(employee.getSex());
		
		employeeRepository.save(emp);
		
		return employee;
	}
	
	public boolean deleteEmployee(Employee employee)
	{
		
		System.out.println("EmployeeService.deleteEmployee()");
		
		boolean status = false;
		Optional<EmployeeTable> emp= employeeRepository.findById(employee.getId());
		if(emp.isPresent())
		{
			employeeRepository.deleteById(employee.getId());
			emp= employeeRepository.findById(employee.getId());
			if(!emp.isPresent())
			{
				status = true;
			}
		}
		return status;
	}
	
	public boolean deleteEmployee(int empId)
	{
		System.out.println("EmployeeService.deleteEmployee()");
		
		Employee employee = new Employee();
		employee.setId(empId);
		boolean status = deleteEmployee(employee);
		return status;
	}
	
	public List<Employee> getAllEmployees()
	{
		List<EmployeeTable> empList =  employeeRepository.findAll();
		List<Employee> employees = new ArrayList<>();
		for(EmployeeTable e : empList)
		{
			Employee emp = new Employee();
			emp.setId(e.getId());
			emp.setAge(e.getAge());
			emp.setName(e.getName());
			emp.setSalary(e.getSalary());
			emp.setSex(e.getSex());
			
			employees.add(emp);
		}
		
		return employees;
		
		//return employeeList;
	}
}
