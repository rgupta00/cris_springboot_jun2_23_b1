package com.empapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.dto.DeptEmpResponse;
import com.empapp.entities.Department;
import com.empapp.excpetions.ResourceNotFoundException;
import com.empapp.repo.DepartmentRepo;

@RestController
public class DeptRestApi {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	
	@GetMapping(path = "deptempinfo")
	public List<DeptEmpResponse> getAllDeptEmpResponse(){
		return departmentRepo.deptEmployeeInformation();
	}
	
	
	
	@GetMapping(path = "departments")
	public List<Department> getAll(){
		return departmentRepo.findAll();
	}
	
	@GetMapping(path = "departments/{id}")
	public Department getAnDept(@PathVariable(name="id") int did){
		return departmentRepo.findById(did)
				.orElseThrow(()-> new ResourceNotFoundException("dept is not found"));
	}
	
}













