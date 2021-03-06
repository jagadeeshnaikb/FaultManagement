package com.bel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "department", schema = "test_schema")
@NamedQuery(name = "Dept.findAll", query = "SELECT dept from DepartmentTable dept")
@NamedQueries
({
@NamedQuery(name="Dept.findByName",  query = "Select dept from DepartmentTable dept where name=:name"),
@NamedQuery(name = "Dept.findById", query = "Select dept from DepartmentTable dept where id=:id"),
@NamedQuery(name = "Dept.updateDepartment", query = "Update DepartmentTable set name=:name, hod=:hod where id=:id")
})
public class DepartmentTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "hod")
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
	
	
}
