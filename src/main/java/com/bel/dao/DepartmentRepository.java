package com.bel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bel.entity.DepartmentTable;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentTable, Integer>{
	
	@Query(name = "Dept.findAll")
	public List<DepartmentTable> findAllDepts();
	
	@Query(value = "Select dept from DepartmentTable dept where id=:idx")
	public List<DepartmentTable> findAllDeptById(@Param("idx") Integer idy);
	
	@Query(name = "Dept.updateDepartment")
	public int updateDepartment(@Param("id") Integer id, @Param("name") String name, @Param("hod") String hod);

}
