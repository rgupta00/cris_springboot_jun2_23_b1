package com.empapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.empapp.entities.Employee;
//I want emp details of id 2 , 3 5 in one go
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	@Query("SELECT e FROM Employee e WHERE e.empId IN (:eid)")
	public List<Employee> findEmployeessByIds(@Param("eid") List<Integer> eid);
}
