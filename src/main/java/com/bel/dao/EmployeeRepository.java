package com.bel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bel.beans.Employee;
import com.bel.entity.EmployeeTable;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTable, Integer> {

	@Query(name = "EmployeeTable.findAll")
	public List<EmployeeTable> findAllEmployees();
	
}
