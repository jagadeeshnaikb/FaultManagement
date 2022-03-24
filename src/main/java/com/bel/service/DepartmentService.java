package com.bel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bel.beans.Department;
import com.bel.dao.DepartmentRepository;
import com.bel.entity.DepartmentTable;

/**
 * 
 * @author JAGADEESH Naik B
 * Department Service
 *
 */

@Service
public class DepartmentService {

	private static List<Department> departmentList = new ArrayList<>();
	private static int count = 0;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department addDepartment(Department department)
	{
		System.out.println("DepartmentService.addDepartment()");
		
		DepartmentTable departmentTable = new DepartmentTable();
		departmentTable.setName(department.getName());
		departmentTable.setHod(department.getHod());
		
		departmentTable =  departmentRepository.save(departmentTable);
		department.setId(departmentTable.getId());
		
		return department;
	}

	public boolean updateDepartment(Department department)
	{
		DepartmentTable departmentTable = new DepartmentTable();
		departmentTable.setName(department.getName());
		departmentTable.setHod(department.getHod());
		departmentTable.setId(department.getId());
		
		departmentTable =  departmentRepository.save(departmentTable);
		if(departmentTable != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateDepartmentUpdate(Department department)
	{
		
		int noOfRecordsUpdated =  departmentRepository.updateDepartment(department.getId(), department.getName(), department.getHod());
		if(noOfRecordsUpdated == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Department findDepartment(int id)
	{
		Optional<DepartmentTable> dept = departmentRepository.findById(id);
		DepartmentTable deptt = dept.get();
		Department department = new Department();
		department.setId(deptt.getId());
		department.setName(deptt.getName());
		department.setHod(deptt.getHod());
		
		return department;
	}

	public boolean deleteDepartment(Department department)
	{
		boolean removed = false;
		Optional<DepartmentTable> dept = departmentRepository.findById(department.getId());
		if(dept.isPresent())
		{
			departmentRepository.deleteById(department.getId());
			dept = departmentRepository.findById(department.getId());
			if(!dept.isPresent())
			{
				removed = true;
			}
		}
		return removed;
	}
	
	public boolean deleteDepartment(int deptId)
	{
		Department department = new Department();
		department.setId(deptId);
		
		boolean removed = deleteDepartment(department);
		return removed;
	}
	
	public List<Department> getAllDepartment()
	{
		List<DepartmentTable> deptList = departmentRepository.findAllDepts();
		
		deptList.forEach(dept -> {
			System.out.println("Id: "+dept.getId()); 
			System.out.println("Name: "+dept.getName()); 
			System.out.println("HOD: "+dept.getHod()); 
			});
		
		List<Department> deptartmentList = new ArrayList<>();
		
		deptList.forEach((dep)-> {
			Department dept = new Department();
			dept.setId(dep.getId());
			dept.setName(dep.getName());
			dept.setHod(dep.getHod());
			deptartmentList.add(dept);
		});
		
		
		
		return deptartmentList;
	}

}
