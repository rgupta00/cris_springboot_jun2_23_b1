package com.empapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empapp.dto.DeptEmpResponse;
import com.empapp.entities.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	@Query("SELECT new com.empapp.dto.DeptEmpResponse(d.deptName, e.empName, e.salary) FROM Department d INNER JOIN d.employees e")
	List<DeptEmpResponse> deptEmployeeInformation();
}

