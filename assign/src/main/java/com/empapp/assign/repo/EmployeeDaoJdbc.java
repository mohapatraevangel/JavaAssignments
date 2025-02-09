package com.empapp.assign.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
@Primary
public class EmployeeDaoJdbc implements EmployeeDao {
    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public void updateEmployee(int id, Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }
}

