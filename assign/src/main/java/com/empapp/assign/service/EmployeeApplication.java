package com.empapp.assign.service;

import com.empapp.repo.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import javax.sql.DataSource;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

        public static void main(String[] args) {
            SpringApplication.run(EmpappApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
//		if(dataSource != null) {
//			System.out.println("jdbcTemplate is not null");
//		}else{
//			System.out.println("jdbcTemplate is null");
//		}
        }
    }
