package com.empapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
@Entity
@Table(name = "department_table")
public class Department {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	
	private String deptName;

	//@JsonIgnore
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,	
			mappedBy ="dept" )
	private List<Employee> employees = new ArrayList<Employee>();

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department() {}

	public Department(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}