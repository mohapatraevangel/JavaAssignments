package com.employee.services;

import com.employee.repo.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();
    public Employee addEmployee (Employee employee);
    public Employee deleteEmployee (int id);
    public Employee updateEmployee (int id, Employee employee);
    public Employee getEmployeeById(int id);
}
