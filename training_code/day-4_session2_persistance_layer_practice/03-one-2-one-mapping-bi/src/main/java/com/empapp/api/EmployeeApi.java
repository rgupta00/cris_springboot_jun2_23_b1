package com.empapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.entities.Employee;
import com.empapp.repo.EmployeeRepo;

@RestController
public class EmployeeApi {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping(path = "employees")
	public List<Employee> getAll(){
		return employeeRepo.findAll();
	}
	
}
