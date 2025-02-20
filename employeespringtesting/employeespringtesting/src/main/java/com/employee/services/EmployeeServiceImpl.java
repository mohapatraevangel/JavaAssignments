package com.employee.services;

import com.employee.exceptions.EmployeeNotFoundException;
import com.employee.repo.Employee;
import com.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
private EmployeeRepo dao;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepo dao) {
        this.dao = dao;
    }

    @Override
    public List<Employee> getEmployees() {
        return dao.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        dao.save(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(int id) {
    Employee empToDelete =getEmployeeById(id);
    dao.delete(empToDelete);
    return empToDelete;


    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee empToUpdate =getEmployeeById(id);
        empToUpdate.setSalary(employee.getSalary());
        dao.save(empToUpdate);
        return empToUpdate;

    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = dao.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with id "+id+" not found"));

        return employee;
    }
}
