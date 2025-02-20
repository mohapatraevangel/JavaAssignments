package com.employee.services;

import com.employee.repo.Employee;
import com.employee.repo.EmployeeRepo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepo dao;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;


    @BeforeEach
    void setUp() {
       employee = new Employee("abc","abc",new BigDecimal(1000));
    }
    @Test
    public void givenEmployee_whenSave_thenReturnEmployee() {

        given(dao.save(employee)).willReturn(employee);
        Employee savedEmp = employeeService.addEmployee(employee);
        assert(savedEmp!=null);

    }
    @Test
    public void givenEmployee_whenFindById_thenReturnEmployee() {
        given(dao.findById(employee.getId())).willReturn(Optional.ofNullable(employee));
        Employee savedEmp = employeeService.getEmployeeById(employee.getId());
        assert(savedEmp!=null);
    }
    @Test
    public void givenEmployeeList_whenFindAll_thenReturnEmployeeList() {
        given(dao.findAll()).willReturn(Collections.singletonList(employee));
        List<Employee> savedEmp = employeeService.getEmployees();
        assert(savedEmp!=null);
    }
//    @Test
//    public void givenEmployee_whenDelete_thenReturnEmployee() {
//        given(dao.findById(employee.getId())).willReturn(Optional.ofNullable(employee));
//        employeeService.deleteEmployee(employee.getId());
//        assertNull(employeeService.getEmployeeById(employee.getId()));
//
//
//    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void getEmployees() {
    }

    @Test
    void addEmployee() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void getEmployeeById() {
    }
}