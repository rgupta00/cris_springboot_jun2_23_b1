package com.empapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int empId;
	private String empName;

	@JoinTable(name = "emp_project_table")
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Project> projects = new ArrayList<Project>();

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee(String empName) {
		this.empName = empName;
	}

	public Employee() {}
	

}




