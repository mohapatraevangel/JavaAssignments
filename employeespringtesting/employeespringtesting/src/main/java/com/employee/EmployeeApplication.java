package com.employee;

import com.employee.repo.Employee;
import com.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "com.employee.entities")
//@EnableJpaRepositories(basePackages = "com.employee.repo")
public class EmployeeApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepo dao;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
//		dao.save(new Employee("Rahul", "IT", 10000));
//		dao.save(new Employee("Ravi", "IT", 20000));
//		System.out.println("Product is added");


	}
}
