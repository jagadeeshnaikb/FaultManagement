package com.bel.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employee database table.
 * 
 */


@Entity
@Table(name = "employee", schema = "test_schema")
@NamedQuery(name="EmployeeTable.findAll", query="SELECT e FROM EmployeeTable e")
public class EmployeeTable implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private Integer age;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private double salary;

	private String sex;

	public EmployeeTable() {
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}