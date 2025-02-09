package com.empapp.assign.controller;
import com.empapp.assign.config.AppConfig;
import com.empapp.assign.repo.Employee;
import com.empapp.service.EmployeeService;
import com.empapp.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
public class DemoController {

    public class DemoController {
        public static void main(String[] args) {
            ApplicationContext ctx=
                    new AnnotationConfigApplicationContext(AppConfig.class);

            EmployeeService service=ctx
                    .getBean("employeeService",EmployeeService.class);

            List<Employee> employees=service.getAllEmployees();

            employees.forEach(System.out::println);
        }
    }
}
