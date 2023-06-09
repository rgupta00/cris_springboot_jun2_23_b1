package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empapp.entities.Department;
import com.empapp.entities.Employee;
import com.empapp.repo.DepartmentRepo;
import com.empapp.repo.EmployeeRepo;

@SpringBootApplication
public class One2OneMappingApplication implements CommandLineRunner {

	@Autowired
	private DepartmentRepo deptRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(One2OneMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Department department1 = new Department("IT");
		Department department2 = new Department("sales");
		Department department3 = new Department("mkt");
		Department department4 = new Department("r&d");

		Employee employee1 = new Employee("raja",50000);
		Employee employee2 = new Employee("amit",59000);
		Employee employee3 = new Employee("sumit",89000);
		Employee employee4 = new Employee("ekta",67000);

		Employee employee5 = new Employee("keshav",70000);
		Employee employee6 = new Employee("gunika",58000);
		Employee employee7 = new Employee("rajiv",88000);

		department1.getEmployees().add(employee1);
		department1.getEmployees().add(employee2);

		department2.getEmployees().add(employee3);
		department2.getEmployees().add(employee4);

		department3.getEmployees().add(employee5);
		department3.getEmployees().add(employee6);
		department3.getEmployees().add(employee7);

		employee1.setDept(department1);
		employee2.setDept(department1);

		employee3.setDept(department2);
		employee4.setDept(department2);

		employee5.setDept(department3);
		employee6.setDept(department3);
		employee7.setDept(department3);
		
		deptRepo.save(department1);
		deptRepo.save(department2);
		deptRepo.save(department3);
		
//		employeeRepo.save(employee1);
//		employeeRepo.save(employee2);
//		employeeRepo.save(employee3);
//		employeeRepo.save(employee4);
//		employeeRepo.save(employee5);
//		employeeRepo.save(employee6);
//		employeeRepo.save(employee7);

	

	
	}

}
